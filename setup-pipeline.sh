#!/bin/bash

# Setup script for AWS CodePipeline + CodeBuild to replace Jenkins

set -e

echo "🚀 Setting up AWS CodePipeline to replace Jenkins..."

# Check if AWS CLI is configured
if ! aws sts get-caller-identity --profile AdministratorAccess-852876132569 > /dev/null 2>&1; then
    echo "❌ AWS CLI not configured. Please run 'aws configure sso' first."
    exit 1
fi

# Get GitHub token
echo "📝 Please enter your GitHub Personal Access Token:"
read -s GITHUB_TOKEN

if [ -z "$GITHUB_TOKEN" ]; then
    echo "❌ GitHub token is required"
    exit 1
fi

# Deploy CloudFormation stack
echo "🏗️  Deploying CloudFormation stack..."
aws cloudformation deploy \
    --template-file pipeline-template.yml \
    --stack-name ecs-fargate-demo-pipeline \
    --parameter-overrides \
        GitHubToken="$GITHUB_TOKEN" \
    --capabilities CAPABILITY_NAMED_IAM \
    --region us-east-1 \
    --profile AdministratorAccess-852876132569

echo "✅ CloudFormation stack deployed successfully!"

# Get stack outputs
PIPELINE_NAME=$(aws cloudformation describe-stacks \
    --stack-name ecs-fargate-demo-pipeline \
    --query 'Stacks[0].Outputs[?OutputKey==`PipelineName`].OutputValue' \
    --output text \
    --region us-east-1 \
    --profile AdministratorAccess-852876132569)

BUILD_PROJECT_NAME=$(aws cloudformation describe-stacks \
    --stack-name ecs-fargate-demo-pipeline \
    --query 'Stacks[0].Outputs[?OutputKey==`BuildProjectName`].OutputValue' \
    --output text \
    --region us-east-1 \
    --profile AdministratorAccess-852876132569)

echo "🎉 Setup complete!"
echo ""
echo "📋 Pipeline Details:"
echo "   Pipeline Name: $PIPELINE_NAME"
echo "   Build Project: $BUILD_PROJECT_NAME"
echo ""
echo "🔗 View your pipeline at:"
echo "   https://us-east-1.console.aws.amazon.com/codesuite/codepipeline/pipelines/$PIPELINE_NAME/view"
echo ""
echo "🔗 View build projects at:"
echo "   https://us-east-1.console.aws.amazon.com/codesuite/codebuild/projects/$BUILD_PROJECT_NAME/history"
echo ""
echo "💡 To trigger a build, simply push to your main branch:"
echo "   git push origin main"
echo ""
echo "🔄 The pipeline will automatically:"
echo "   1. Pull code from GitHub"
echo "   2. Build the Docker image"
echo "   3. Push to ECR"
echo "   4. Deploy to ECS"
echo ""
echo "💰 Cost comparison:"
echo "   - Jenkins on EC2: ~$30-50/month (t3.medium + storage)"
echo "   - CodePipeline + CodeBuild: ~$5-15/month (pay-per-use)"
echo ""
echo "🧹 To clean up your Jenkins EC2 instance later:"
echo "   - Stop the EC2 instance"
echo "   - Terminate it when you're confident the new pipeline works" 