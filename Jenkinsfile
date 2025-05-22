pipeline {
    agent any

    environment {
        AWS_REGION = 'us-east-1'
        ECR_REPO = 'ecs-fargate-demo'
        ECS_CLUSTER = 'ecs-fargate-demo'
        ECS_SERVICE = 'ecs-fargate-demo-service-l94qrn1z'
        TASK_FAMILY = 'ecs-fargate-demo'
        IMAGE_TAG = "${env.BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/recolons/ecs-fargate-demo.git'
            }
        }

        stage('Login to ECR') {
            steps {
                script {
                    sh '''
                    aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin $(aws sts get-caller-identity --query Account --output text).dkr.ecr.$AWS_REGION.amazonaws.com
                    '''
                }
            }
        }

        stage('Build Java') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def accountId = sh(script: "aws sts get-caller-identity --query Account --output text", returnStdout: true).trim()
                    def imageUri = "${accountId}.dkr.ecr.${AWS_REGION}.amazonaws.com/${ECR_REPO}:${IMAGE_TAG}"

                    sh "docker build -t ${imageUri} ."
                    sh "docker push ${imageUri}"
                }
            }
        }

        stage('Register New Task Definition') {
            steps {
                script {
                    def accountId = sh(script: "aws sts get-caller-identity --query Account --output text", returnStdout: true).trim()
                    def imageUri = "${accountId}.dkr.ecr.${AWS_REGION}.amazonaws.com/${ECR_REPO}:${IMAGE_TAG}".toString()

                    def taskDefJson = sh(script: "aws ecs describe-task-definition --region us-east-1 --task-definition ${TASK_FAMILY}", returnStdout: true).trim()
                    def taskDef = readJSON text: taskDefJson

                    // Modify the container image
                    taskDef.taskDefinition.containerDefinitions[0].image = imageUri

                    // Preserve existing secrets configuration
                    def secrets = [
                        [
                            name: "SPRING_PROFILES_ACTIVE",
                            valueFrom: "arn:aws:ssm:us-east-1:852876132569:parameter/ecs-demo/spring-profiles-active"
                        ],
                        [
                            name: "DB_NAME",
                            valueFrom: "arn:aws:ssm:us-east-1:852876132569:parameter/ecs-demo/db-name"
                        ],
                        [
                            name: "DB_PORT",
                            valueFrom: "arn:aws:ssm:us-east-1:852876132569:parameter/ecs-demo/db-port"
                        ],
                        [
                            name: "DB_PASSWORD",
                            valueFrom: "arn:aws:ssm:us-east-1:852876132569:parameter/ecs-demo/db-password"
                        ],
                        [
                            name: "DB_USER",
                            valueFrom: "arn:aws:ssm:us-east-1:852876132569:parameter/ecs-demo/db-username"
                        ],
                        [
                            name: "DB_HOST",
                            valueFrom: "arn:aws:ssm:us-east-1:852876132569:parameter/ecs-demo/rds-endpoint"
                        ]
                    ]
                    
                    taskDef.taskDefinition.containerDefinitions[0].secrets = secrets

                    // Remove unnecessary fields before registering
                    def newTaskDef = taskDef.taskDefinition
                    newTaskDef.remove('taskDefinitionArn')
                    newTaskDef.remove('revision')
                    newTaskDef.remove('status')
                    newTaskDef.remove('requiresAttributes')
                    newTaskDef.remove('compatibilities')
                    newTaskDef.remove('registeredAt')
                    newTaskDef.remove('registeredBy')

                    writeJSON file: 'new-task-def.json', json: newTaskDef

                    sh "aws ecs register-task-definition --region us-east-1 --cli-input-json file://new-task-def.json"
                }
            }
        }

        stage('Update ECS Service') {
            steps {
                script {
                    sh "aws ecs update-service --cluster ${ECS_CLUSTER} --service ${ECS_SERVICE} --force-new-deployment"
                }
            }
        }
    }
}
