USE f1_db;

-- 1. Полностью очищаем таблицу от дубликатов и сбрасываем счетчик id
TRUNCATE TABLE standings;

-- 2. Делаем имя гонщика уникальным, чтобы база больше не давала вставлять дубли
ALTER TABLE standings ADD UNIQUE (name);

-- 3. Вставляем 25 пилотов один раз
INSERT INTO standings (name, points, number, team) VALUES
('Andrea Kimi Antonelli', 390, '12', 'Mercedes'),
('Max Verstappen', 279, '3', 'Red Bull'),
('George Russell', 262, '63', 'Mercedes'),
('Lewis Hamilton', 261, '44', 'Ferrari'),
('Charles Leclerc', 251, '16', 'Ferrari'),
('Lando Norris', 246, '1', 'McLaren'),
('Oscar Piastri', 152, '81', 'McLaren'),
('Isack Hadjar', 122, '6', 'Red Bull'),
('Liam Lawson', 87, '30', 'RB'),
('Pierre Gasly', 42, '10', 'Alpine'),
('Arvid Lindblad', 38, '17', 'RB'),
('Franco Colapinto', 27, '43', 'Alpine'),
('Oliver Bearman', 23, '87', 'Haas Racing'),
('Gabriel Bortoleto', 14, '11', 'Audi'),
('Nico Hulkenberg', 14, '27', 'Audi'),
('Carlos Sainz', 7, '55', 'Williams'),
('Esteban Ocon', 7, '31', 'Haas Racing'),
('Fernando Alonso', 7, '14', 'Aston Martin'),
('Alexander Albon', 5, '23', 'Williams'),
('Yuki Tsunoda', 1, '22', 'RB'),
('Ryo Hirakawa', 1, '99', 'Haas Racing'),
('Lance Stroll', 0, '18', 'Aston Martin'),
('Valtteri Bottas', 0, '77', 'Mercedes'),
('Sergio Perez', 0, '11', 'Red Bull'),
('Rafael Camara', 0, '29', 'Haas Racing');
