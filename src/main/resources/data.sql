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
INSERT INTO articles (title, content, date, section_id) VALUES
('Messi gana su séptimo Balón de Oro', 'Lionel Messi ha sido galardonado con su séptimo Balón de Oro...', CURRENT_TIMESTAMP, 1),
('Real Madrid campeón de la Champions', 'El Real Madrid ha ganado su decimocuarta Champions League...', CURRENT_TIMESTAMP, 1),
('Nuevo récord mundial en 100m', 'El atleta ha batido el récord mundial en los 100 metros...', CURRENT_TIMESTAMP, 1),
('Federer anuncia su retiro', 'El tenista suizo Roger Federer ha anunciado su retiro...', CURRENT_TIMESTAMP, 1),
('Selección nacional clasifica al Mundial', 'La selección nacional ha conseguido su pase al Mundial...', CURRENT_TIMESTAMP, 1),
('Nuevo fichaje del Barcelona', 'El Barcelona ha anunciado el fichaje de un nuevo jugador...', CURRENT_TIMESTAMP, 1),
('Victoria histórica en el clásico', 'El clásico ha terminado con un resultado histórico...', CURRENT_TIMESTAMP, 1),
('Lesión grave en la Premier League', 'Un jugador ha sufrido una lesión grave durante el partido...', CURRENT_TIMESTAMP, 1),
('Nuevo estadio para el Mundial 2026', 'Se ha presentado el diseño del nuevo estadio...', CURRENT_TIMESTAMP, 1),
('Campeonato de Fórmula 1', 'El campeonato de Fórmula 1 está más emocionante que nunca...', CURRENT_TIMESTAMP, 1),
('Triunfo en el Tour de Francia', 'El ciclista ha ganado su primera etapa en el Tour...', CURRENT_TIMESTAMP, 1),
('Nuevo récord en la NBA', 'Un jugador ha batido el récord de puntos en un partido...', CURRENT_TIMESTAMP, 1),
('Final de la Copa Libertadores', 'La final de la Copa Libertadores promete ser emocionante...', CURRENT_TIMESTAMP, 1),
('Olimpiadas 2024', 'Los preparativos para las Olimpiadas 2024 avanzan...', CURRENT_TIMESTAMP, 1),
('Nuevo entrenador para la selección', 'La federación ha anunciado el nuevo entrenador...', CURRENT_TIMESTAMP, 1),
('Victoria en el torneo de tenis', 'El tenista ha ganado su primer torneo del año...', CURRENT_TIMESTAMP, 1),
('Clasificación para la Eurocopa', 'La selección ha conseguido su pase a la Eurocopa...', CURRENT_TIMESTAMP, 1),
('Nuevo récord en natación', 'La nadadora ha batido el récord mundial...', CURRENT_TIMESTAMP, 1),
('Final de la Copa del Rey', 'La final de la Copa del Rey está programada...', CURRENT_TIMESTAMP, 1),
('Campeonato de baloncesto', 'El campeonato de baloncesto llega a su fase final...', CURRENT_TIMESTAMP, 1),
('Nuevo estadio para el equipo', 'El equipo ha presentado los planes para su nuevo estadio...', CURRENT_TIMESTAMP, 1),
('Lesión en el equipo campeón', 'Un jugador clave ha sufrido una lesión...', CURRENT_TIMESTAMP, 1),
('Transferencia récord', 'Se ha completado la transferencia más cara de la historia...', CURRENT_TIMESTAMP, 1),
('Nuevo patrocinador del equipo', 'El equipo ha anunciado su nuevo patrocinador principal...', CURRENT_TIMESTAMP, 1),
('Preparación para el Mundial', 'La selección comienza su preparación para el Mundial...', CURRENT_TIMESTAMP, 1);

-- Insert articles for Noticias section
INSERT INTO articles (title, content, date, section_id) VALUES
('Nuevo avance en la investigación del cáncer', 'Científicos han logrado un importante avance...', CURRENT_TIMESTAMP, 2),
('Cambio climático: nuevas medidas', 'Los líderes mundiales han acordado nuevas medidas...', CURRENT_TIMESTAMP, 2),
('Avance tecnológico revolucionario', 'Una nueva tecnología promete revolucionar el mercado...', CURRENT_TIMESTAMP, 2),
('Crisis económica global', 'Los expertos analizan la situación económica mundial...', CURRENT_TIMESTAMP, 2),
('Nuevo descubrimiento arqueológico', 'Arqueólogos han encontrado ruinas antiguas...', CURRENT_TIMESTAMP, 2),
('Reforma educativa aprobada', 'El parlamento ha aprobado la nueva reforma educativa...', CURRENT_TIMESTAMP, 2),
('Avance en energía renovable', 'Nueva tecnología solar promete mayor eficiencia...', CURRENT_TIMESTAMP, 2),
('Crisis migratoria en Europa', 'La situación migratoria en Europa se intensifica...', CURRENT_TIMESTAMP, 2),
('Nuevo récord en el mercado de valores', 'El mercado de valores alcanza nuevos máximos...', CURRENT_TIMESTAMP, 2),
('Avance en inteligencia artificial', 'Nuevo modelo de IA supera expectativas...', CURRENT_TIMESTAMP, 2),
('Reforma sanitaria propuesta', 'El gobierno presenta nueva reforma sanitaria...', CURRENT_TIMESTAMP, 2),
('Crisis energética mundial', 'Los precios de la energía alcanzan nuevos récords...', CURRENT_TIMESTAMP, 2),
('Nuevo tratado internacional', 'Países firman importante tratado comercial...', CURRENT_TIMESTAMP, 2),
('Avance en medicina preventiva', 'Nuevo método de detección temprana de enfermedades...', CURRENT_TIMESTAMP, 2),
('Crisis alimentaria global', 'La ONU alerta sobre crisis alimentaria mundial...', CURRENT_TIMESTAMP, 2),
('Nuevo récord en el espacio', 'Astronautas establecen nuevo récord en el espacio...', CURRENT_TIMESTAMP, 2),
('Reforma laboral aprobada', 'El congreso aprueba nueva reforma laboral...', CURRENT_TIMESTAMP, 2),
('Avance en transporte sostenible', 'Nuevo vehículo eléctrico rompe récords...', CURRENT_TIMESTAMP, 2),
('Crisis de vivienda', 'Los precios de la vivienda siguen aumentando...', CURRENT_TIMESTAMP, 2),
('Nuevo descubrimiento científico', 'Científicos descubren nueva especie animal...', CURRENT_TIMESTAMP, 2),
('Reforma fiscal propuesta', 'El gobierno presenta nueva reforma fiscal...', CURRENT_TIMESTAMP, 2),
('Avance en telecomunicaciones', 'Nueva tecnología 6G promete mayor velocidad...', CURRENT_TIMESTAMP, 2),
('Crisis de seguridad cibernética', 'Aumentan los ataques cibernéticos globales...', CURRENT_TIMESTAMP, 2),
('Nuevo acuerdo comercial', 'Países firman importante acuerdo comercial...', CURRENT_TIMESTAMP, 2),
('Avance en agricultura sostenible', 'Nueva técnica agrícola promete mayor rendimiento...', CURRENT_TIMESTAMP, 2);

-- Insert articles for Tecnología section
INSERT INTO articles (title, content, date, section_id) VALUES
('Nuevo avance en inteligencia artificial', 'OpenAI presenta su último modelo de lenguaje que supera todas las expectativas...', CURRENT_TIMESTAMP, 3),
('Apple anuncia su nuevo iPhone', 'La compañía de Cupertino revela las características del próximo iPhone...', CURRENT_TIMESTAMP, 3),
('Revolución en la computación cuántica', 'IBM logra un nuevo hito en la computación cuántica...', CURRENT_TIMESTAMP, 3),
('El futuro de la realidad virtual', 'Meta presenta sus nuevos avances en tecnología VR...', CURRENT_TIMESTAMP, 3),
('Ciberseguridad: nuevas amenazas', 'Expertos advierten sobre el aumento de ataques cibernéticos...', CURRENT_TIMESTAMP, 3),
('They Asked an A.I. Chatbot Questions. The Answers Sent Them Spiraling.', 'In a groundbreaking study, researchers conducted extensive interviews with an advanced AI chatbot, revealing unexpected psychological impacts on participants. The AI''s responses, while technically accurate, triggered existential questions and emotional distress in many subjects. Some reported feeling overwhelmed by the AI''s ability to articulate complex philosophical concepts, while others experienced anxiety about the future of human-AI relationships. The study highlights the need for better understanding of AI''s psychological impact on users and suggests implementing safeguards to prevent potential mental health concerns. Researchers emphasize the importance of developing ethical guidelines for AI interactions, particularly as these technologies become more sophisticated and widely accessible.' , CURRENT_TIMESTAMP, 3);

-- Insert articles for Entretenimiento section
INSERT INTO articles (title, content, date, section_id) VALUES
('Nueva temporada de Stranger Things', 'Netflix anuncia la fecha de estreno de la última temporada...', CURRENT_TIMESTAMP, 4),
('Festival de Cannes 2024', 'Las películas más esperadas del festival de cine...', CURRENT_TIMESTAMP, 4),
('Concierto histórico en el Madison Square Garden', 'Artista rompe récord de asistencia en el legendario recinto...', CURRENT_TIMESTAMP, 4),
('Nueva serie de HBO', 'La plataforma presenta su próxima producción estrella...', CURRENT_TIMESTAMP, 4),
('Premios Grammy 2024', 'Lista completa de nominados y ganadores...', CURRENT_TIMESTAMP, 4);

-- Insert articles for Horóscopo section
INSERT INTO articles (title, content, date, section_id) VALUES
('Predicciones astrológicas para 2024', 'Los astros revelan lo que depara el año para cada signo...', CURRENT_TIMESTAMP, 5),
('Luna llena en Escorpio', 'Cómo aprovechar la energía de esta poderosa luna...', CURRENT_TIMESTAMP, 5),
('Compatibilidad amorosa de la semana', 'Descubre tu compatibilidad con otros signos...', CURRENT_TIMESTAMP, 5),
('Mercurio retrógrado: guía de supervivencia', 'Consejos para navegar este período astrológico...', CURRENT_TIMESTAMP, 5),
('Rituales de luna nueva', 'Actividades para aprovechar la energía de la luna nueva...', CURRENT_TIMESTAMP, 5);

-- Insert articles for Política section
INSERT INTO articles (title, content, date, section_id) VALUES
('Nueva ley de reforma fiscal', 'El congreso debate los cambios propuestos al sistema fiscal...', CURRENT_TIMESTAMP, 6),
('Cumbre internacional sobre cambio climático', 'Líderes mundiales se reúnen para discutir medidas ambientales...', CURRENT_TIMESTAMP, 6),
('Elecciones presidenciales 2024', 'Análisis de las principales propuestas de los candidatos...', CURRENT_TIMESTAMP, 6),
('Reforma migratoria', 'Nuevas políticas sobre inmigración en debate...', CURRENT_TIMESTAMP, 6),
('Acuerdo comercial internacional', 'Países firman nuevo tratado de libre comercio...', CURRENT_TIMESTAMP, 6);

-- Insert articles for Salud section
INSERT INTO articles (title, content, date, section_id) VALUES
('Nuevo avance en tratamiento del cáncer', 'Investigadores presentan resultados prometedores...', CURRENT_TIMESTAMP, 7),
('Guía de alimentación saludable', 'Expertos en nutrición comparten sus recomendaciones...', CURRENT_TIMESTAMP, 7),
('Beneficios del ejercicio diario', 'Estudio revela impacto positivo en la salud mental...', CURRENT_TIMESTAMP, 7),
('Nueva vacuna contra la gripe', 'Autoridades sanitarias aprueban nueva formulación...', CURRENT_TIMESTAMP, 7),
('Meditación y bienestar', 'Cómo la práctica diaria mejora la calidad de vida...', CURRENT_TIMESTAMP, 7);

-- Insert articles for Ciencia section
INSERT INTO articles (title, content, date, section_id) VALUES
('Descubrimiento de nueva especie marina', 'Científicos encuentran criatura en las profundidades...', CURRENT_TIMESTAMP, 8),
('Avance en fusión nuclear', 'Laboratorio logra nuevo récord de energía sostenida...', CURRENT_TIMESTAMP, 8),
('Misión espacial a Marte', 'NASA anuncia nuevos hallazgos en el planeta rojo...', CURRENT_TIMESTAMP, 8),
('Estudio sobre el cambio climático', 'Nuevos datos revelan aceleración del calentamiento global...', CURRENT_TIMESTAMP, 8),
('Investigación en genética', 'Científicos logran nuevo avance en edición genética...', CURRENT_TIMESTAMP, 8);

-- Insert articles for Cultura section
INSERT INTO articles (title, content, date, section_id) VALUES
('Exposición de arte contemporáneo', 'Museo presenta muestra de artistas emergentes...', CURRENT_TIMESTAMP, 9),
('Festival de literatura', 'Escritores internacionales se reúnen para celebrar la palabra...', CURRENT_TIMESTAMP, 9),
('Patrimonio cultural en peligro', 'UNESCO alerta sobre sitios históricos amenazados...', CURRENT_TIMESTAMP, 9),
('Nueva tendencia en arquitectura', 'Diseñadores presentan conceptos innovadores...', CURRENT_TIMESTAMP, 9),
('Revival de la música clásica', 'Orquestas jóvenes reviven composiciones olvidadas...', CURRENT_TIMESTAMP, 9);

-- Insert articles for Economía section
INSERT INTO articles (title, content, date, section_id) VALUES
('Perspectivas económicas 2024', 'Analistas predicen tendencias para el próximo año...', CURRENT_TIMESTAMP, 10),
('Mercado laboral en transformación', 'Nuevas profesiones emergen con la tecnología...', CURRENT_TIMESTAMP, 10),
('Comercio internacional', 'Análisis de las relaciones comerciales globales...', CURRENT_TIMESTAMP, 10),
('Desarrollo sostenible', 'Empresas adoptan modelos económicos verdes...', CURRENT_TIMESTAMP, 10),
('Innovación en modelos de negocio', 'Startups revolucionan industrias tradicionales...', CURRENT_TIMESTAMP, 10);

-- Insert articles for Finanzas section
INSERT INTO articles (title, content, date, section_id) VALUES
('Guía de inversión para principiantes', 'Expertos comparten estrategias básicas...', CURRENT_TIMESTAMP, 11),
('Mercado de criptomonedas', 'Análisis de las últimas tendencias en blockchain...', CURRENT_TIMESTAMP, 11),
('Planificación financiera personal', 'Consejos para alcanzar la independencia financiera...', CURRENT_TIMESTAMP, 11),
('Fondos de inversión 2024', 'Ranking de los mejores fondos del mercado...', CURRENT_TIMESTAMP, 11),
('Tecnología financiera', 'Fintech revoluciona los servicios bancarios...', CURRENT_TIMESTAMP, 11);

-- Insert articles for Educación section
INSERT INTO articles (title, content, date, section_id) VALUES
('Revolución en la educación online', 'Plataformas digitales transforman el aprendizaje...', CURRENT_TIMESTAMP, 12),
('Nuevas metodologías educativas', 'Escuelas adoptan enfoques innovadores...', CURRENT_TIMESTAMP, 12),
('Educación STEM', 'Importancia de la ciencia y tecnología en las aulas...', CURRENT_TIMESTAMP, 12),
('Becas internacionales 2024', 'Oportunidades de estudio en el extranjero...', CURRENT_TIMESTAMP, 12),
('Futuro de las universidades', 'Cómo la IA está cambiando la educación superior...', CURRENT_TIMESTAMP, 12); 