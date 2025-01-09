-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 25-11-2024 a las 22:33:55
-- Versión del servidor: 8.0.40-0ubuntu0.22.04.1
-- Versión de PHP: 8.1.2-1ubuntu2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spotify`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `album`
--

CREATE TABLE `album` (
  `id` int NOT NULL,
  `anioo` int DEFAULT NULL,
  `direccion_imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `artista` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `album`
--

INSERT INTO `album` (`id`, `anioo`, `direccion_imagen`, `nombre`, `artista`) VALUES
(1, 1980, 'includes/albumes/Village.jpeg', 'Village People Live and Sleazy', 'vpeople'),
(2, 1990, 'includes/albumes/Violator.jpeg', 'Violator', 'dmode'),
(3, 1983, 'includes/albumes/She.jpeg', 'She’s So Unusual', 'clauper'),
(4, 1984, 'includes/albumes/Born.jpeg', 'Born In The U.S.A.', 'bruceTheBoss'),
(5, 1965, 'includes/albumes/It’sNot.jpeg', 'It’s Not Unusual', 'tigerOfWales'),
(6, 2012, 'includes/albumes/AguaYSal.jpeg', 'Agua Y Sal', 'tripleNelson'),
(7, 2001, 'includes/albumes/MTV.jpeg', 'MTV Unplugged', 'la_ley'),
(8, 1875, 'includes/albumes/ElLago.jpeg', 'El Lago De Los Cisnes', 'chaiko'),
(9, 1875, 'includes/albumes/Concierto.jpeg', 'Concierto Para Piano No. 1 En Si Menor, Opus 2', 'chaiko'),
(10, 1994, 'includes/albumes/Primer.jpeg', 'Primer Amor', 'nicoleneu'),
(11, 1993, 'includes/albumes/HayAmores.jpeg', 'Hay Amores Que Matan', 'lospimpi'),
(12, 1993, 'includes/albumes/UnLoco.jpeg', 'Un Loco Como Yo', 'dyangounchained'),
(13, 1989, 'includes/albumes/20Grandes.jpeg', '20 Grandes Éxitos', 'alcides'),
(651, 1234, 'includes/albumes/album.jpg', 'album machi', 'machi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `album_canciones`
--

CREATE TABLE `album_canciones` (
  `album_id` int NOT NULL,
  `cancion_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `album_canciones`
--

INSERT INTO `album_canciones` (`album_id`, `cancion_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(3, 6),
(3, 7),
(4, 8),
(4, 9),
(4, 10),
(5, 11),
(6, 12),
(7, 13),
(7, 14),
(8, 15),
(9, 16),
(10, 17),
(11, 18),
(12, 19),
(13, 20),
(651, 652),
(651, 653);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `album_genero`
--

CREATE TABLE `album_genero` (
  `album_id` int NOT NULL,
  `generos_nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `album_genero`
--

INSERT INTO `album_genero` (`album_id`, `generos_nombre`) VALUES
(11, 'Balada'),
(12, 'Balada'),
(8, 'Clásica'),
(9, 'Clásica'),
(13, 'Cumbia'),
(1, 'Dance-pop'),
(3, 'Dance-pop'),
(1, 'Disco'),
(2, 'Electropop'),
(10, 'Electropop'),
(1, 'Pop Clásico'),
(3, 'Pop Clásico'),
(4, 'Pop Clásico'),
(5, 'Pop Clásico'),
(7, 'Pop Clásico'),
(11, 'Pop Clásico'),
(12, 'Pop Clásico'),
(4, 'Rock & Roll'),
(4, 'Rock Clásico'),
(5, 'Rock Clásico'),
(6, 'Rock Latino'),
(7, 'Rock Latino'),
(651, 'Rock Latino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artista`
--

CREATE TABLE `artista` (
  `nick` varchar(255) NOT NULL,
  `DireccionWeb` varchar(255) DEFAULT NULL,
  `biografia` varchar(1200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `artista`
--

INSERT INTO `artista` (`nick`, `DireccionWeb`, `biografia`) VALUES
('alcides', NULL, 'Alcides es un cantante argentino que comenzó su carrera en 1976 con la banda Los Playeros. Su éxito se consolidó en los años 1990 con el lanzamiento de varios álbumes populares.'),
('bruceTheBoss', 'brucespringsteen.net', ''),
('chaiko', NULL, 'Piotr Ilich Chaikovski fue un compositor ruso del período del Romanticismo. Sus obras abarcan una variedad de géneros, incluyendo sinfonías, óperas y ballets.'),
('clauper', 'cyndilauper.com', 'Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Después de participar en el grupo musical, Blue Angel, en 1983 firmó con Portrait Records y lanzó su exitoso álbum debut She\'s So '),
('dmode', 'www.depechemode.com', ''),
('dyangounchained', NULL, 'Dyango es un cantante español conocido por su música romántica y sus baladas sentimentales.'),
('la_ley', NULL, ''),
('lospimpi', 'www.pimpinela.net', ''),
('machi', 'https://youtube.com', 'biografias.com'),
('nicoleneu', 'bit.ly/nicoleneu', ''),
('tigerOfWales', 'www.tomjones.com', 'Tom Jones es un cantante británico conocido por su potente voz y sus éxitos en los géneros del pop y del soul. Ha vendido más de 100 millones de discos en todo el mundo.'),
('tripleNelson', NULL, 'La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998. Su música se caracteriza por su estilo rockero y letras profundas.'),
('vpeople', 'www.officialvillagepeople.com', 'Village People es una innovadora formación musical de estilo disco de finales de los años 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancion`
--

CREATE TABLE `cancion` (
  `id` int NOT NULL,
  `direccion_archivo_de_audio` varchar(255) DEFAULT NULL,
  `duracion` int DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `reproducciones` int NOT NULL,
  `descargas` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cancion`
--

INSERT INTO `cancion` (`id`, `direccion_archivo_de_audio`, `duracion`, `nombre`, `genero`, `reproducciones`, `descargas`) VALUES
(1, 'includes/musica/Village People - YMCA.mp3', 268, 'YMCA', NULL, 13, 0),
(2, 'includes/musica/Village People - Macho Man.mp3', 208, 'Macho Man', NULL, 3, 0),
(3, 'includes/musica/Village People - In the Navy - Original Version 1979.mp3', 193, 'In the Navy', NULL, 3, 0),
(4, 'includes/musica/Depeche Mode - Personal Jesus.mp3', NULL, 'Personal Jesus', NULL, 0, 0),
(5, 'includes/musica/Depeche Mode - Enjoy the Silence.mp3', NULL, 'Enjoy The Silence', NULL, 0, 0),
(6, 'includes/musica/Cyndi Lauper - Girls Just Want to Have Fun.mp3', 195, 'Girls Just Want To Have Fun', NULL, 5, 0),
(7, 'includes/musica/Cyndi Lauper - Time After Time.mp3', 312, 'Time After Time', NULL, 5, 0),
(8, 'includes/musica/Bruce Springsteen - Born in the U.S.A..mp3', 298, 'Born In The U.S.A.', NULL, 3, 1),
(9, 'includes/musica/Bruce Springsteen - Glory Days.mp3', 323, 'Glory Days', NULL, 0, 0),
(10, 'includes/musica/Bruce Springsteen - Dancing In the Dark.mp3', 238, 'Dancing In The Park', NULL, 1, 0),
(11, 'includes/musica/Tom Jones - It\'s Not Unusual.mp3', 120, 'It’s Not Unusual', NULL, 0, 0),
(12, 'includes/musica/Alfredo Zitarrosa - Adagio en Mi País.mp3', 290, 'Adagio De Mi País', NULL, 4, 0),
(13, 'includes/musica/La Ley - El Duelo.mp3', 323, 'El Duelo', NULL, 0, 0),
(14, 'includes/musica/La Ley - Mentira.mp3', 288, 'Mentira', NULL, 0, 0),
(15, 'includes/musica/Pyotr Ilyich Tchaikovsky, Inma Shara - El Lago De Los Cisnes - Op. 20, Acto II- 10. Scene (Moderato).mp3', 160, 'Acto 2, Número 10, Escena (Moderato)', NULL, 13, 0),
(16, 'includes/musica/Orquestra de Câmara de Blumenau - Allegro.mp3', 1318, 'Primer Movimiento (Allegro non troppo e molto maestoso – Allegro con spirito)', NULL, 1, 1),
(17, 'includes/musica/JAY WONDER 01 - No Quiero Estudiar.mp3', 132, 'No Quiero Estudiar', NULL, 0, 0),
(18, 'includes/musica/Pimpinela, Dyango - Por Ese Hombre.mp3', 285, 'Por Ese Hombre', NULL, 51, 0),
(19, 'includes/musica/Pimpinela, Dyango - Por Ese Hombreee.mp3', 313, 'Por Ese Hombre', NULL, 0, 0),
(20, 'includes/musica/Alcides - Violeta.mp3', 116, 'Violeta', 'Pop', 0, 1),
(652, 'includes/musica/cancion.mp3', 195, 'cancion1', NULL, 0, 0),
(653, 'includes/musica/cancion.mp3', 195, 'cancion1', NULL, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `nick` varchar(255) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fecSub` date DEFAULT NULL,
  `tipo` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nick`, `estado`, `fecSub`, `tipo`) VALUES
('benKenobi', 'Cancelado', NULL, NULL),
('bob', 'Vigente', '2024-10-08', 12),
('cbochinche', 'Cancelado', NULL, NULL),
('el_padrino', 'Cancelado', NULL, NULL),
('Eleven11', 'Cancelado', NULL, NULL),
('Heisenberg', 'Cancelado', NULL, NULL),
('lachiqui', 'Vigente', '2024-11-25', 365),
('ppArgento', 'Cancelado', NULL, NULL),
('scarlettO', 'Cancelado', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_albumesFavoritos`
--

CREATE TABLE `cliente_albumesFavoritos` (
  `cliente_id` varchar(255) NOT NULL,
  `album_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente_albumesFavoritos`
--

INSERT INTO `cliente_albumesFavoritos` (`cliente_id`, `album_id`) VALUES
('vpeople', 2),
('ppArgento', 8),
('vpeople', 8),
('ppArgento', 9),
('vpeople', 9),
('cbochinche', 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_cancionesFavoritas`
--

CREATE TABLE `cliente_cancionesFavoritas` (
  `cliente_id` varchar(255) NOT NULL,
  `cancion_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente_cancionesFavoritas`
--

INSERT INTO `cliente_cancionesFavoritas` (`cliente_id`, `cancion_id`) VALUES
('bob', 3),
('ppArgento', 6),
('bob', 8),
('vpeople', 11),
('bob', 12),
('lachiqui', 12),
('bob', 15),
('cbochinche', 15),
('el_padrino', 17);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_playlistFavoritas`
--

CREATE TABLE `cliente_playlistFavoritas` (
  `cliente_id` varchar(255) NOT NULL,
  `playlist_particular_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente_playlistFavoritas`
--

INSERT INTO `cliente_playlistFavoritas` (`cliente_id`, `playlist_particular_id`) VALUES
('cbochinche', 1),
('ppArgento', 1),
('vpeople', 1),
('cbochinche', 2),
('ppArgento', 2),
('scarlettO', 3),
('vpeople', 3),
('Heisenberg', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_usuariosSeguidos`
--

CREATE TABLE `cliente_usuariosSeguidos` (
  `cliente_id` varchar(255) NOT NULL,
  `usuario_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente_usuariosSeguidos`
--

INSERT INTO `cliente_usuariosSeguidos` (`cliente_id`, `usuario_id`) VALUES
('benKenobi', 'alcides'),
('cbochinche', 'alcides'),
('Heisenberg', 'alcides'),
('lachiqui', 'alcides'),
('el_padrino', 'benKenobi'),
('Heisenberg', 'benKenobi'),
('ppArgento', 'benKenobi'),
('scarlettO', 'benKenobi'),
('benKenobi', 'bruceTheBoss'),
('Heisenberg', 'bruceTheBoss'),
('lachiqui', 'bruceTheBoss'),
('ppArgento', 'bruceTheBoss'),
('scarlettO', 'bruceTheBoss'),
('benKenobi', 'cbochinche'),
('el_padrino', 'cbochinche'),
('ppArgento', 'cbochinche'),
('benKenobi', 'chaiko'),
('el_padrino', 'clauper'),
('benKenobi', 'dmode'),
('el_padrino', 'dmode'),
('Heisenberg', 'dmode'),
('ppArgento', 'dmode'),
('scarlettO', 'dmode'),
('cbochinche', 'dyangounchained'),
('Heisenberg', 'dyangounchained'),
('benKenobi', 'el_padrino'),
('Eleven11', 'el_padrino'),
('Heisenberg', 'el_padrino'),
('lachiqui', 'el_padrino'),
('benKenobi', 'Eleven11'),
('el_padrino', 'Eleven11'),
('Heisenberg', 'Eleven11'),
('ppArgento', 'Eleven11'),
('scarlettO', 'Heisenberg'),
('benKenobi', 'la_ley'),
('cbochinche', 'la_ley'),
('Eleven11', 'la_ley'),
('lachiqui', 'la_ley'),
('benKenobi', 'lachiqui'),
('bob', 'lachiqui'),
('el_padrino', 'lachiqui'),
('Heisenberg', 'lachiqui'),
('ppArgento', 'lachiqui'),
('scarlettO', 'lachiqui'),
('benKenobi', 'lospimpi'),
('cbochinche', 'lospimpi'),
('Heisenberg', 'lospimpi'),
('lachiqui', 'lospimpi'),
('benKenobi', 'nicoleneu'),
('benKenobi', 'ppArgento'),
('cbochinche', 'ppArgento'),
('Eleven11', 'ppArgento'),
('Heisenberg', 'ppArgento'),
('lachiqui', 'ppArgento'),
('Eleven11', 'scarlettO'),
('Heisenberg', 'scarlettO'),
('lachiqui', 'scarlettO'),
('Heisenberg', 'tigerOfWales'),
('scarlettO', 'tigerOfWales'),
('Heisenberg', 'tripleNelson'),
('ppArgento', 'tripleNelson'),
('scarlettO', 'tripleNelson'),
('el_padrino', 'vpeople');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `nombre` varchar(255) NOT NULL,
  `padre_nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`nombre`, `padre_nombre`) VALUES
('Balada', NULL),
('Clásica', NULL),
('Cumbia', NULL),
('Disco', NULL),
('Pop', NULL),
('Rock', NULL),
('Dance-pop', 'Pop'),
('Electropop', 'Pop'),
('Pop Clásico', 'Pop'),
('Rock & Roll', 'Rock'),
('Rock Clásico', 'Rock'),
('Rock Latino', 'Rock');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `log_sesion`
--

CREATE TABLE `log_sesion` (
  `ID` bigint NOT NULL,
  `ip_usuario` varchar(255) NOT NULL,
  `navegador` varchar(255) NOT NULL,
  `sistema_operativo` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `log_sesion`
--

INSERT INTO `log_sesion` (`ID`, `ip_usuario`, `navegador`, `sistema_operativo`, `url`) VALUES
(1, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(2, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(3, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(4, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(5, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(6, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(7, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(8, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(9, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(10, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(11, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(12, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/rankingUsuarios.jsp'),
(13, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=lachiqui'),
(14, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=lachiqui'),
(15, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=clauper'),
(16, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(17, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(18, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(19, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(20, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(21, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(22, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(23, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(24, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(25, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(26, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(27, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(28, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(29, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(30, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(31, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(32, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(33, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(34, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(35, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(36, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(37, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(38, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(39, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(40, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(41, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(42, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(43, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(44, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(45, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(46, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(47, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(48, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(49, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(50, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(51, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(52, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(53, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(54, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(55, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(56, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(57, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(58, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(59, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(60, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(61, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(62, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(63, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(64, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(65, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(66, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(67, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(68, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(69, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(70, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(71, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(72, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(73, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(74, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(75, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(76, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(77, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(78, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(79, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(80, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(81, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(82, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(83, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(84, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(85, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(86, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(87, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(88, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(89, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(90, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(91, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(92, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(93, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(94, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(95, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(96, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(97, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(98, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(99, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(100, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(101, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(102, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(103, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(104, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(105, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(106, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(107, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(108, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(109, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=5'),
(110, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=5'),
(111, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(112, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(113, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(114, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(115, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(116, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(117, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(118, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(119, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(120, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(121, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=vpeople&user=1'),
(122, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(123, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(124, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(125, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(126, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(127, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(128, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(129, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(130, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(131, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(132, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(133, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(134, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(135, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(136, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(137, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(138, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(139, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(140, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(141, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(142, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(143, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(144, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(145, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(146, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(147, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(148, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(149, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(150, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(151, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(152, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(153, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(154, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(155, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(156, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(157, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(158, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(159, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(160, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(161, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(162, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(163, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(164, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(165, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(166, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(167, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(168, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(169, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(170, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(171, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(172, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(173, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(174, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(175, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(176, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(177, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(178, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(179, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(180, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(181, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(182, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(183, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(184, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(185, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(186, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(187, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(188, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(189, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(190, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(191, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(192, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(193, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=5'),
(194, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(195, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(196, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(197, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(198, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(199, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(200, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(201, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(202, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(203, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(204, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(205, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=5'),
(206, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(207, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(208, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(209, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=8'),
(210, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(211, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(212, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(213, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(214, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(215, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(216, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(217, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(218, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(219, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(220, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(221, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(222, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(223, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(224, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(225, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(226, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(227, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(228, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/rankingUsuarios.jsp'),
(229, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(230, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(231, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(232, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(233, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=10'),
(234, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(235, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(236, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(237, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(238, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(239, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(240, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(241, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(242, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(243, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(244, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(245, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(246, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(247, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(248, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(249, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(250, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(251, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(252, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(253, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(254, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(255, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(256, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(257, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(258, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(259, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(260, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(261, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(262, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(263, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(264, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=12'),
(265, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=4'),
(266, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=el_padrino'),
(267, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=el_padrino'),
(268, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=el_padrino'),
(269, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/rankingUsuarios.jsp'),
(270, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(271, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(272, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(273, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(274, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(275, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylistVisitante.jsp?user=4'),
(276, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(277, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(278, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylistVisitante.jsp?user=4'),
(279, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(280, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(281, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp?searchBar=ins'),
(282, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(283, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylistVisitante.jsp?user=4'),
(284, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp?searchBar=ins'),
(285, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(286, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylistVisitante.jsp?user=4'),
(287, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp?searchBar=ins'),
(288, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(289, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylistVisitante.jsp?user=4'),
(290, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp?searchBar=ins'),
(291, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(292, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylistVisitante.jsp?user=4'),
(293, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp?searchBar=ins'),
(294, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(295, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylistVisitante.jsp?user=4'),
(296, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp?searchBar=ins'),
(297, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(298, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylistVisitante.jsp?user=4'),
(299, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/index.jsp?'),
(300, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/welcome.jsp'),
(301, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/principalWelcome.jsp'),
(302, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/login.jsp'),
(303, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/index.jsp?'),
(304, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/principal.jsp'),
(305, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/rankingUsuarios.jsp'),
(306, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/principal.jsp?user=bob'),
(307, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/consultarUsuario.jsp?user=tigerOfWales'),
(308, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=tigerOfWales&user=5'),
(309, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=tigerOfWales&user=5'),
(310, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=tigerOfWales'),
(311, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=nicoleneu'),
(312, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=bruceTheBoss'),
(313, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=chaiko'),
(314, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=clauper'),
(315, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=dmode'),
(316, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=dyangounchained'),
(317, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=lospimpi'),
(318, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(319, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(320, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(321, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(322, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(323, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(324, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(325, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(326, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(327, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(328, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?&user=bob'),
(329, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(330, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(331, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?&user=bob'),
(332, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(333, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(334, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(335, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(336, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(337, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(338, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(339, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(340, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(341, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(342, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(343, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(344, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(345, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(346, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(347, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(348, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(349, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(350, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(351, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(352, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(353, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(354, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(355, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(356, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(357, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(358, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(359, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(360, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(361, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(362, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=4'),
(363, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(364, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(365, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=4'),
(366, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(367, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(368, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(369, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(370, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(371, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=4'),
(372, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(373, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(374, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(375, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(376, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(377, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(378, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(379, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(380, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(381, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(382, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(383, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(384, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=2'),
(385, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(386, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=3'),
(387, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=3'),
(388, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(389, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(390, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(391, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(392, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(393, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(394, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(395, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(396, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(397, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(398, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(399, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(400, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(401, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(402, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(403, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(404, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(405, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(406, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(407, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(408, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(409, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(410, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(411, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(412, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(413, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(414, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(415, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(416, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(417, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(418, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=4'),
(419, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(420, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(421, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(422, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=el_padrino'),
(423, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=4'),
(424, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(425, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/rankingUsuarios.jsp'),
(426, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(427, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(428, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(429, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(430, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/principal.jsp'),
(431, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(432, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(433, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/index.jsp?'),
(434, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/welcome.jsp'),
(435, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/principalWelcome.jsp'),
(436, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/login.jsp'),
(437, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(438, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(439, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(440, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(441, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(442, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(443, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(444, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/index.jsp?'),
(445, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/principal.jsp'),
(446, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(447, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(448, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(449, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/index.jsp'),
(450, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/principal.jsp'),
(451, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=tripleNelson&user=6'),
(452, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(453, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(454, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(455, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(456, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(457, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(458, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(459, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=lachiqui'),
(460, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=dmode&user=2'),
(461, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(462, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(463, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=dyangounchained&user=12'),
(464, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(465, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(466, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=clauper&user=3'),
(467, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(468, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(469, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=chaiko&user=8'),
(470, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(471, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(472, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=tigerOfWales&user=5'),
(473, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(474, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(475, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(476, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=la_ley&user=7'),
(477, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=la_ley&user=7'),
(478, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=clauper&user=3'),
(479, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=clauper'),
(480, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=lachiqui'),
(481, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=tigerOfWales&user=5'),
(482, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=tigerOfWales&user=5'),
(483, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=tigerOfWales&user=5'),
(484, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=bruceTheBoss&user=4'),
(485, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(486, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(487, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=alcides&user=13'),
(488, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(489, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(490, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(491, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp');
INSERT INTO `log_sesion` (`ID`, `ip_usuario`, `navegador`, `sistema_operativo`, `url`) VALUES
(492, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(493, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(494, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=nicoleneu&user=10'),
(495, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=nicoleneu&user=10'),
(496, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(497, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(498, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=chaiko&user=9'),
(499, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/index.jsp'),
(500, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/welcome.jsp'),
(501, '127.0.1.1', 'Apple Safari', 'Mac OS', 'http://192.168.1.139:8080/SpotifyWeb/principalWelcome.jsp'),
(502, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(503, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(504, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(505, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(506, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(507, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(508, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(509, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(510, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(511, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(512, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(513, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(514, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(515, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(516, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(517, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(518, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(519, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(520, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(521, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(522, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(523, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(524, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(525, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(526, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(527, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(528, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(529, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(530, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(531, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(532, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(533, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(534, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(535, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(536, '127.0.1.1', 'Mozilla Firefox', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(537, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(538, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(539, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(540, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(541, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(542, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(543, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(544, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(545, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(546, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(547, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(548, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(549, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=13'),
(550, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(551, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?&user=bob'),
(552, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(553, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarFavoritos.jsp'),
(554, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/rankingUsuarios.jsp'),
(555, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(556, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=lospimpi'),
(557, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(558, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=nicoleneu&user=10'),
(559, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(560, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=1'),
(561, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(562, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(563, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(564, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=scarlettO'),
(565, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=scarlettO'),
(566, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/rankingUsuarios.jsp'),
(567, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/rankingUsuarios.jsp'),
(568, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=scarlettO'),
(569, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=scarlettO'),
(570, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=3'),
(571, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(572, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(573, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=3'),
(574, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(575, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=14'),
(576, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(577, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?&user=14'),
(578, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(579, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarPlaylist.jsp?user=14'),
(580, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=bob'),
(581, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?&user=bob'),
(582, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(583, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(584, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=clauper'),
(585, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/rankingUsuarios.jsp'),
(586, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp?user=bob'),
(587, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(588, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(589, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(590, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(591, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp'),
(592, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp'),
(593, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp'),
(594, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(595, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(596, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp'),
(597, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(598, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(599, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(600, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(601, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(602, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(603, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(604, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(605, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/'),
(606, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/welcome.jsp'),
(607, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principalWelcome.jsp'),
(608, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(609, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(610, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(611, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(612, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/register.jsp'),
(613, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp?'),
(614, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(615, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(616, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/AltaAlbum.jsp'),
(617, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(618, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(619, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=machi'),
(620, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/ConsultarAlbum.jsp?tipo=artista&nombre=machi&user=651'),
(621, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/consultarUsuario.jsp?user=machi'),
(622, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(623, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp'),
(624, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/login.jsp'),
(625, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/index.jsp?'),
(626, '127.0.1.1', 'Google Chrome', 'Linux', 'http://localhost:8080/SpotifyWeb/principal.jsp');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlist`
--

CREATE TABLE `playlist` (
  `id` int NOT NULL,
  `DTYPE` varchar(31) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  `rutaImagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `playlist`
--

INSERT INTO `playlist` (`id`, `DTYPE`, `Nombre`, `rutaImagen`) VALUES
(1, 'PlaylistPorDefecto', 'Noche De La Nostalgia', 'includes/playlist/nostalgia.jpeg'),
(2, 'PlaylistPorDefecto', 'Rock En Español', NULL),
(3, 'PlaylistPorDefecto', 'Música Clásica', 'includes/playlist/musicaCla.jpeg'),
(4, 'PlaylistParticular', 'Música Inspiradora', 'includes/playlist/musicInspi.jpeg'),
(5, 'PlaylistParticular', 'De Todo Un Poco', NULL),
(6, 'PlaylistParticular', 'Para Cocinar', 'includes/playlist/ParaCocinar.jpeg'),
(7, 'PlaylistParticular', 'Para Las Chicas', NULL),
(8, 'PlaylistParticular', 'Fiesteras', 'includes/playlist/fiestaFiesta.jpeg'),
(9, 'PlaylistParticular', 'Mis Favoritas', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlistparticular`
--

CREATE TABLE `playlistparticular` (
  `id` int NOT NULL,
  `privada` tinyint(1) DEFAULT '0',
  `propietario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `playlistparticular`
--

INSERT INTO `playlistparticular` (`id`, `privada`, `propietario`) VALUES
(4, 0, 'el_padrino'),
(5, 0, 'el_padrino'),
(6, 1, 'Heisenberg'),
(7, 0, 'lachiqui'),
(8, 0, 'cbochinche'),
(9, 1, 'cbochinche');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlistpordefecto`
--

CREATE TABLE `playlistpordefecto` (
  `id` int NOT NULL,
  `genero_nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `playlistpordefecto`
--

INSERT INTO `playlistpordefecto` (`id`, `genero_nombre`) VALUES
(3, 'Clásica'),
(1, 'Pop Clásico'),
(2, 'Rock Latino');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlist_cancion`
--

CREATE TABLE `playlist_cancion` (
  `playlist_id` int NOT NULL,
  `canciones_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `playlist_cancion`
--

INSERT INTO `playlist_cancion` (`playlist_id`, `canciones_id`) VALUES
(1, 1),
(8, 1),
(1, 2),
(8, 2),
(1, 3),
(8, 3),
(4, 4),
(6, 4),
(6, 5),
(1, 6),
(5, 6),
(7, 6),
(1, 7),
(5, 7),
(1, 8),
(6, 8),
(1, 9),
(6, 9),
(8, 9),
(1, 10),
(1, 11),
(5, 11),
(7, 11),
(2, 12),
(9, 12),
(2, 13),
(2, 14),
(3, 15),
(4, 15),
(5, 15),
(3, 16),
(4, 16),
(7, 16),
(9, 16),
(7, 17),
(7, 18),
(9, 18),
(8, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `SEQUENCE`
--

CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `SEQUENCE`
--

INSERT INTO `SEQUENCE` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '700');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nick` varchar(255) NOT NULL,
  `tipo_usuario` varchar(31) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `fecNac` date DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nick`, `tipo_usuario`, `apellido`, `password`, `fecNac`, `imagen`, `mail`, `nombre`) VALUES
('alcides', 'artista', NULL, '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1952-07-17', NULL, 'alcides@tuta.io', 'Alcides'),
('benKenobi', 'cliente', 'Kenobi', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1914-04-02', 'includes/Usuarios/benKenobi.jpeg', 'benKenobi@gmail.com', 'Obi-Wan'),
('bob', 'cliente', 'bob', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '2005-10-03', 'includes/Usuarios/Heisenberg.jpeg', 'bob', 'bob'),
('bruceTheBoss', 'artista', 'Springsteen', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1949-09-23', 'includes/Usuarios/bruceTheBoss.jpeg', 'bruceTheBoss@gmail.com', 'Bruce'),
('cbochinche', 'cliente', 'Bochinche', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1937-05-08', 'includes/Usuarios/Bochinche.jpeg', 'cbochinche@vera.com.uy', 'Cacho'),
('chaiko', 'artista', 'Tchaikovsky', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1840-04-25', NULL, 'chaiko@tuta.io', 'Piotr'),
('clauper', 'artista', 'Lauper', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1953-06-22', 'includes/Usuarios/Lauper.jpeg', 'clauper@hotmail.com', 'Cyndi'),
('dmode', 'artista', 'Mode', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1980-06-14', 'includes/Usuarios/Mode.jpeg', 'dmode@tuta.io', 'Depeche'),
('dyangounchained', 'artista', NULL, '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1940-03-05', NULL, 'dyangounchained@gmail.com', 'Dyango'),
('el_padrino', 'cliente', 'Corleone', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1972-03-08', 'includes/Usuarios/el_padrino.jpeg', 'el_padrino@tuta.io', 'Vito'),
('Eleven11', 'cliente', NULL, '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1971-12-31', 'includes/Usuarios/Eleven11.jpeg', 'Eleven11@gmail.com', 'Eleven'),
('Heisenberg', 'cliente', 'White', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1956-03-07', 'includes/Usuarios/Heisenberg.jpeg', 'Heisenberg@tuta.io', 'Walter'),
('la_ley', 'artista', 'Ley', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1987-02-14', NULL, 'la_ley@tuta.io', 'La'),
('lachiqui', 'cliente', 'Legrand', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1927-02-23', 'includes/Usuarios/lachiqui.jpeg', 'rmatias088@gmail.com', 'Mirtha'),
('lospimpi', 'artista', NULL, '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1981-08-13', 'includes/Usuarios/lospimpi.jpeg', 'lospimpi@gmail.com', 'Pimpinela'),
('machi', 'artista', 'rodriguez', '$2a$10$QCO15ABpRxKlz04tR9giT.o1l4mGgVXi11G03A6AzIL5m1fe.nO.m', '2024-11-01', 'fotosDePerfil/imagenDefault.png', 'correo@correo.com', 'matias'),
('nicoleneu', 'artista', 'Neumann', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1980-10-31', 'includes/Usuarios/nicoleneu.jpeg', 'nicoleneu@hotmail.com', 'Nicole'),
('ppArgento', 'cliente', 'Argento', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1955-02-14', 'includes/Usuarios/ppArgento.jpeg', 'ppArgento@hotmail.com', 'Pepe'),
('scarlettO', 'cliente', 'O’Hara', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1984-11-27', 'includes/Usuarios/scarlettO.jpg', 'scarlettO@tuta.io', 'Scarlett'),
('tigerOfWales', 'artista', 'Jones', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1940-06-07', NULL, 'tigerOfWales@tuta.io', 'Tom'),
('tripleNelson', 'artista', 'Nelson', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1998-01-01', 'includes/Usuarios/tripleNelson.jpeg', 'tripleNelson@tuta.io', 'La Triple'),
('vpeople', 'artista', 'People', '$2a$10$idOxpNoD3vgGoV3HU1WnG..faz0iiXxePlFhYmUNNacG5IdGl4.U2', '1977-01-01', 'includes/Usuarios/vpeople.jpeg', 'vpeople@tuta.io', 'Village');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_album_artista` (`artista`);

--
-- Indices de la tabla `album_canciones`
--
ALTER TABLE `album_canciones`
  ADD PRIMARY KEY (`album_id`,`cancion_id`),
  ADD KEY `FK_album_canciones_cancion_id` (`cancion_id`);

--
-- Indices de la tabla `album_genero`
--
ALTER TABLE `album_genero`
  ADD PRIMARY KEY (`album_id`,`generos_nombre`),
  ADD KEY `FK_album_genero_generos_nombre` (`generos_nombre`);

--
-- Indices de la tabla `artista`
--
ALTER TABLE `artista`
  ADD PRIMARY KEY (`nick`);

--
-- Indices de la tabla `cancion`
--
ALTER TABLE `cancion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_cancion_genero` (`genero`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`nick`);

--
-- Indices de la tabla `cliente_albumesFavoritos`
--
ALTER TABLE `cliente_albumesFavoritos`
  ADD PRIMARY KEY (`cliente_id`,`album_id`),
  ADD KEY `FK_cliente_albumesFavoritos_album_id` (`album_id`);

--
-- Indices de la tabla `cliente_cancionesFavoritas`
--
ALTER TABLE `cliente_cancionesFavoritas`
  ADD PRIMARY KEY (`cliente_id`,`cancion_id`),
  ADD KEY `FK_cliente_cancionesFavoritas_cancion_id` (`cancion_id`);

--
-- Indices de la tabla `cliente_playlistFavoritas`
--
ALTER TABLE `cliente_playlistFavoritas`
  ADD PRIMARY KEY (`cliente_id`,`playlist_particular_id`),
  ADD KEY `cliente_playlistFavoritas_playlist_particular_id` (`playlist_particular_id`);

--
-- Indices de la tabla `cliente_usuariosSeguidos`
--
ALTER TABLE `cliente_usuariosSeguidos`
  ADD PRIMARY KEY (`cliente_id`,`usuario_id`),
  ADD KEY `FK_cliente_usuariosSeguidos_usuario_id` (`usuario_id`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `FK_genero_padre_nombre` (`padre_nombre`);

--
-- Indices de la tabla `log_sesion`
--
ALTER TABLE `log_sesion`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `playlistparticular`
--
ALTER TABLE `playlistparticular`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_playlistparticular_propietario` (`propietario`);

--
-- Indices de la tabla `playlistpordefecto`
--
ALTER TABLE `playlistpordefecto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_playlistpordefecto_genero_nombre` (`genero_nombre`);

--
-- Indices de la tabla `playlist_cancion`
--
ALTER TABLE `playlist_cancion`
  ADD PRIMARY KEY (`playlist_id`,`canciones_id`),
  ADD KEY `FK_playlist_cancion_canciones_id` (`canciones_id`);

--
-- Indices de la tabla `SEQUENCE`
--
ALTER TABLE `SEQUENCE`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`nick`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `log_sesion`
--
ALTER TABLE `log_sesion`
  MODIFY `ID` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=627;

--
-- AUTO_INCREMENT de la tabla `playlist`
--
ALTER TABLE `playlist`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `album`
--
ALTER TABLE `album`
  ADD CONSTRAINT `FK_album_artista` FOREIGN KEY (`artista`) REFERENCES `usuario` (`nick`);

--
-- Filtros para la tabla `album_canciones`
--
ALTER TABLE `album_canciones`
  ADD CONSTRAINT `FK_album_canciones_album_id` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`),
  ADD CONSTRAINT `FK_album_canciones_cancion_id` FOREIGN KEY (`cancion_id`) REFERENCES `cancion` (`id`);

--
-- Filtros para la tabla `album_genero`
--
ALTER TABLE `album_genero`
  ADD CONSTRAINT `FK_album_genero_album_id` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`),
  ADD CONSTRAINT `FK_album_genero_generos_nombre` FOREIGN KEY (`generos_nombre`) REFERENCES `genero` (`nombre`);

--
-- Filtros para la tabla `artista`
--
ALTER TABLE `artista`
  ADD CONSTRAINT `FK_artista_nick` FOREIGN KEY (`nick`) REFERENCES `usuario` (`nick`);

--
-- Filtros para la tabla `cancion`
--
ALTER TABLE `cancion`
  ADD CONSTRAINT `FK_cancion_genero` FOREIGN KEY (`genero`) REFERENCES `genero` (`nombre`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK_cliente_nick` FOREIGN KEY (`nick`) REFERENCES `usuario` (`nick`);

--
-- Filtros para la tabla `cliente_albumesFavoritos`
--
ALTER TABLE `cliente_albumesFavoritos`
  ADD CONSTRAINT `FK_cliente_albumesFavoritos_album_id` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`),
  ADD CONSTRAINT `FK_cliente_albumesFavoritos_cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`nick`);

--
-- Filtros para la tabla `cliente_cancionesFavoritas`
--
ALTER TABLE `cliente_cancionesFavoritas`
  ADD CONSTRAINT `FK_cliente_cancionesFavoritas_cancion_id` FOREIGN KEY (`cancion_id`) REFERENCES `cancion` (`id`),
  ADD CONSTRAINT `FK_cliente_cancionesFavoritas_cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`nick`);

--
-- Filtros para la tabla `cliente_playlistFavoritas`
--
ALTER TABLE `cliente_playlistFavoritas`
  ADD CONSTRAINT `cliente_playlistFavoritas_playlist_particular_id` FOREIGN KEY (`playlist_particular_id`) REFERENCES `playlist` (`id`),
  ADD CONSTRAINT `FK_cliente_playlistFavoritas_cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`nick`);

--
-- Filtros para la tabla `cliente_usuariosSeguidos`
--
ALTER TABLE `cliente_usuariosSeguidos`
  ADD CONSTRAINT `FK_cliente_usuariosSeguidos_cliente_id` FOREIGN KEY (`cliente_id`) REFERENCES `usuario` (`nick`),
  ADD CONSTRAINT `FK_cliente_usuariosSeguidos_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`nick`);

--
-- Filtros para la tabla `genero`
--
ALTER TABLE `genero`
  ADD CONSTRAINT `FK_genero_padre_nombre` FOREIGN KEY (`padre_nombre`) REFERENCES `genero` (`nombre`);

--
-- Filtros para la tabla `playlistparticular`
--
ALTER TABLE `playlistparticular`
  ADD CONSTRAINT `FK_playlistparticular_id` FOREIGN KEY (`id`) REFERENCES `playlist` (`id`),
  ADD CONSTRAINT `FK_playlistparticular_propietario` FOREIGN KEY (`propietario`) REFERENCES `usuario` (`nick`);

--
-- Filtros para la tabla `playlistpordefecto`
--
ALTER TABLE `playlistpordefecto`
  ADD CONSTRAINT `FK_playlistpordefecto_genero_nombre` FOREIGN KEY (`genero_nombre`) REFERENCES `genero` (`nombre`),
  ADD CONSTRAINT `FK_playlistpordefecto_id` FOREIGN KEY (`id`) REFERENCES `playlist` (`id`);

--
-- Filtros para la tabla `playlist_cancion`
--
ALTER TABLE `playlist_cancion`
  ADD CONSTRAINT `FK_playlist_cancion_canciones_id` FOREIGN KEY (`canciones_id`) REFERENCES `cancion` (`id`),
  ADD CONSTRAINT `FK_playlist_cancion_playlist_id` FOREIGN KEY (`playlist_id`) REFERENCES `playlist` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
