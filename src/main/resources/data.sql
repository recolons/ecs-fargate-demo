-- Insert sections
INSERT INTO sections (name) VALUES ('deportes');
INSERT INTO sections (name) VALUES ('noticias');

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