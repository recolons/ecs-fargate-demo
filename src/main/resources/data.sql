-- Insert sections
INSERT INTO sections (name) VALUES ('Deportes');
INSERT INTO sections (name) VALUES ('Noticias');
INSERT INTO sections (name) VALUES ('Tecnología');
INSERT INTO sections (name) VALUES ('Entretenimiento');
INSERT INTO sections (name) VALUES ('Horóscopo');
INSERT INTO sections (name) VALUES ('Política');
INSERT INTO sections (name) VALUES ('Salud');
INSERT INTO sections (name) VALUES ('Ciencia');
INSERT INTO sections (name) VALUES ('Cultura');
INSERT INTO sections (name) VALUES ('Economía');
INSERT INTO sections (name) VALUES ('Finanzas');
INSERT INTO sections (name) VALUES ('Educación');

-- Insert articles for Deportes section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Messi gana su séptimo Balón de Oro', 'Juan Pérez', 'Lionel Messi hace historia al ganar su séptimo Balón de Oro', 'En una ceremonia cargada de emoción en el Teatro Châtelet de París, Lionel Messi ha sido galardonado con su séptimo Balón de Oro, consolidando su posición como uno de los mejores futbolistas de todos los tiempos. El argentino, que actualmente milita en el Inter Miami, superó a sus competidores gracias a su destacada actuación en el Mundial de Qatar 2022, donde lideró a su selección hacia la gloria. Durante la temporada, Messi demostró una vez más su clase excepcional, registrando 21 goles y 20 asistencias en 41 partidos con el PSG, además de ser el máximo goleador de la Copa del Mundo con 7 tantos. "Es un honor increíble recibir este premio por séptima vez. Quiero agradecer a todos mis compañeros, al cuerpo técnico y especialmente a mi familia por su apoyo incondicional", declaró el astro argentino. Este nuevo galardón lo sitúa dos trofeos por encima de su eterno rival, Cristiano Ronaldo, y refuerza su legado en la historia del fútbol. La votación final fue muy ajustada, con Erling Haaland y Kylian Mbappé completando el podio.', 'https://i.eurosport.com/2023/10/30/3815800-77567929-640-480.jpg', 'https://example.com/messi2.jpg', NULL, CURRENT_TIMESTAMP, 1),
(UUID(), 'Real Madrid campeón de la Champions', 'María García', 'El Real Madrid conquista su decimocuarta Champions League', 'El Real Madrid ha ganado su decimocuarta Champions League...', 'https://example.com/champions1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 1),
(UUID(), 'Nuevo récord mundial en 100m', 'Carlos López', 'Atleta rompe el récord mundial en los 100 metros', 'El atleta ha batido el récord mundial en los 100 metros...', 'https://example.com/atletismo1.jpg', 'https://example.com/atletismo2.jpg', 'https://example.com/atletismo3.jpg', CURRENT_TIMESTAMP, 1),
(UUID(), 'Federer anuncia su retiro', 'Laura Martínez', 'El tenista suizo pone fin a su legendaria carrera', 'El tenista suizo Roger Federer ha anunciado su retiro después de una carrera legendaria...', 'https://example.com/federer1.jpg', 'https://example.com/federer2.jpg', NULL, CURRENT_TIMESTAMP, 1),
(UUID(), 'Selección nacional clasifica al Mundial', 'Pedro Sánchez', 'La selección consigue su pase al Mundial 2026', 'La selección nacional ha conseguido su pase al Mundial tras una emocionante victoria...', 'https://example.com/seleccion1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 1),
(UUID(), 'Nuevo fichaje del Barcelona', 'Ana Torres', 'El Barcelona anuncia el fichaje de un nuevo jugador estrella', 'El Barcelona ha anunciado el fichaje de un nuevo jugador que promete revolucionar el equipo...', 'https://example.com/barcelona1.jpg', 'https://example.com/barcelona2.jpg', 'https://example.com/barcelona3.jpg', CURRENT_TIMESTAMP, 1),
(UUID(), 'Victoria histórica en el clásico', 'Diego Ramírez', 'El clásico termina con un resultado histórico', 'El clásico ha terminado con un resultado histórico que quedará en la memoria de los aficionados...', 'https://example.com/clasico1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 1),
(UUID(), 'Lesión grave en la Premier League', 'Carlos Ruiz', 'Un jugador sufre una lesión grave durante el partido', 'Un jugador ha sufrido una lesión grave durante el partido que lo mantendrá fuera de las canchas...', 'https://example.com/lesion1.jpg', 'https://example.com/lesion2.jpg', NULL, CURRENT_TIMESTAMP, 1),
(UUID(), 'Nuevo estadio para el Mundial 2026', 'María López', 'Se presenta el diseño del nuevo estadio para el Mundial', 'Se ha presentado el diseño del nuevo estadio que albergará partidos del Mundial 2026...', 'https://example.com/estadio1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 1),
(UUID(), 'Campeonato de Fórmula 1', 'Roberto García', 'El campeonato de Fórmula 1 está más emocionante que nunca', 'El campeonato de Fórmula 1 está más emocionante que nunca con la lucha por el título...', 'https://example.com/f1_1.jpg', 'https://example.com/f1_2.jpg', 'https://example.com/f1_3.jpg', CURRENT_TIMESTAMP, 1),
(UUID(), 'Triunfo en el Tour de Francia', 'Isabel Sánchez', 'Ciclista gana su primera etapa en el Tour', 'El ciclista ha ganado su primera etapa en el Tour de Francia en una carrera épica...', 'https://example.com/tour1.jpg', 'https://example.com/tour2.jpg', NULL, CURRENT_TIMESTAMP, 1);

-- Insert articles for Noticias section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Nuevo avance en la investigación del cáncer', 'Ana Martínez', 'Científicos logran importante avance en la lucha contra el cáncer', 'Científicos han logrado un importante avance...', 'https://example.com/cancer1.jpg', 'https://example.com/cancer2.jpg', NULL, CURRENT_TIMESTAMP, 2),
(UUID(), 'Cambio climático: nuevas medidas', 'Roberto Sánchez', 'Líderes mundiales acuerdan medidas contra el cambio climático', 'Los líderes mundiales han acordado nuevas medidas...', 'https://example.com/clima1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 2);

-- Insert articles for Tecnología section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Nuevo avance en inteligencia artificial', 'Laura Torres', 'OpenAI presenta su último modelo de lenguaje revolucionario', 'OpenAI presenta su último modelo de lenguaje que supera todas las expectativas...', 'https://example.com/ai1.jpg', 'https://example.com/ai2.jpg', 'https://example.com/ai3.jpg', CURRENT_TIMESTAMP, 3),
(UUID(), 'Apple anuncia su nuevo iPhone', 'Pedro Ramírez', 'Apple revela las características del próximo iPhone', 'La compañía de Cupertino revela las características del próximo iPhone...', 'https://example.com/iphone1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 3);

-- Insert articles for Entretenimiento section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Nueva temporada de Stranger Things', 'Carmen Ruiz', 'Netflix anuncia la fecha de estreno de la última temporada', 'Netflix anuncia la fecha de estreno de la última temporada...', 'https://example.com/stranger1.jpg', 'https://example.com/stranger2.jpg', NULL, CURRENT_TIMESTAMP, 4),
(UUID(), 'Festival de Cannes 2024', 'Diego Moreno', 'Las películas más esperadas del festival de cine', 'Las películas más esperadas del festival de cine...', 'https://example.com/cannes1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 4);

-- Insert articles for Horóscopo section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Predicciones astrológicas para 2024', 'Sofía Vega', 'Los astros revelan lo que depara el año para cada signo', 'Los astros revelan lo que depara el año para cada signo...', 'https://example.com/horoscopo1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 5);

-- Insert articles for Política section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Nueva ley de reforma fiscal', 'Miguel Ángel López', 'El congreso debate los cambios propuestos al sistema fiscal', 'El congreso debate los cambios propuestos al sistema fiscal...', 'https://example.com/politica1.jpg', 'https://example.com/politica2.jpg', NULL, CURRENT_TIMESTAMP, 6);

-- Insert articles for Salud section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Nuevo avance en tratamiento del cáncer', 'Dra. Elena Martínez', 'Investigadores presentan resultados prometedores en tratamiento del cáncer', 'Investigadores presentan resultados prometedores...', 'https://example.com/salud1.jpg', 'https://example.com/salud2.jpg', 'https://example.com/salud3.jpg', CURRENT_TIMESTAMP, 7);

-- Insert articles for Ciencia section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Descubrimiento de nueva especie marina', 'Dr. Javier Rodríguez', 'Científicos encuentran criatura en las profundidades del océano', 'Científicos encuentran criatura en las profundidades...', 'https://example.com/ciencia1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 8);

-- Insert articles for Cultura section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Exposición de arte contemporáneo', 'Isabel Torres', 'Museo presenta muestra de artistas emergentes', 'Museo presenta muestra de artistas emergentes...', 'https://example.com/cultura1.jpg', 'https://example.com/cultura2.jpg', NULL, CURRENT_TIMESTAMP, 9);

-- Insert articles for Economía section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Perspectivas económicas 2024', 'Ricardo Gómez', 'Analistas predicen tendencias para el próximo año', 'Analistas predicen tendencias para el próximo año...', 'https://example.com/economia1.jpg', NULL, NULL, CURRENT_TIMESTAMP, 10);

-- Insert articles for Finanzas section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Guía de inversión para principiantes', 'Alberto Sánchez', 'Expertos comparten estrategias básicas de inversión', 'Expertos comparten estrategias básicas...', 'https://example.com/finanzas1.jpg', 'https://example.com/finanzas2.jpg', NULL, CURRENT_TIMESTAMP, 11);

-- Insert articles for Educación section
INSERT INTO articles (id, title, author, description, content, image_url1, image_url2, image_url3, date_published, section_id) VALUES
(UUID(), 'Revolución en la educación online', 'Prof. María González', 'Plataformas digitales transforman el aprendizaje', 'Plataformas digitales transforman el aprendizaje...', 'https://example.com/educacion1.jpg', 'https://example.com/educacion2.jpg', 'https://example.com/educacion3.jpg', CURRENT_TIMESTAMP, 12); 