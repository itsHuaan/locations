-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 30, 2024 at 08:09 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vietnam`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_location`
--

CREATE TABLE `tbl_location` (
  `locationId` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `parentId` int(11) DEFAULT NULL,
  `coords` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `tbl_location`
--

INSERT INTO `tbl_location` (`locationId`, `name`, `parentId`, `coords`) VALUES
(1, 'Tây Bắc Bộ', 0, NULL),
(2, 'Đông Bắc Bộ', 0, NULL),
(3, 'Đồng bằng sông Hồng', 0, NULL),
(4, 'Bắc Trung Bộ', 0, NULL),
(5, 'Nam Trung Bộ', 0, NULL),
(6, 'Tây Nguyên', 0, NULL),
(7, 'Đông Nam Bộ', 0, NULL),
(8, 'Đồng bằng sông Cửu Long', 0, NULL),
(9, 'Lào Cai', 1, '22.3385, 104.1487'),
(10, 'Yên Bái', 1, '21.7229, 104.9115'),
(11, 'Điện Biên', 1, '21.3877, 103.0166'),
(12, 'Hoà Bình', 1, '20.6861, 105.3419'),
(13, 'Lai Châu', 1, '22.3817, 103.4707'),
(14, 'Sơn La', 1, '21.3285, 103.9144'),
(15, 'Hà Giang', 2, '22.8233, 104.983'),
(16, 'Cao Bằng', 2, '22.6730, 106.2507'),
(17, 'Bắc Kạn', 2, '22.1445, 105.8412'),
(18, 'Lạng Sơn', 2, '21.8544, 106.6291'),
(19, 'Tuyên Quang', 2, '21.8113, 105.2130'),
(20, 'Thái Nguyên', 2, '21.5626, 105.8445'),
(21, 'Phú Thọ', 2, '21.3219, 105.2180'),
(22, 'Bắc Giang', 2, '21.2733, 106.1946'),
(23, 'Quảng Ninh', 2, '21.0064, 107.2925'),
(24, 'Bắc Ninh', 3, '21.1214, 106.1111'),
(25, 'Hà Nam', 3, '20.5830, 105.9160'),
(26, 'Hà Nội', 3, '21.0285, 105.8542'),
(27, 'Hải Dương', 3, '20.9351, 106.3210'),
(28, 'Hải Phòng', 3, '20.8449, 106.6881'),
(29, 'Hưng Yên', 3, '20.6467, 106.0511'),
(30, 'Nam Định', 3, '20.4251, 106.1748'),
(31, 'Ninh Bình', 3, '20.2506, 105.9745'),
(32, 'Thái Bình', 3, '20.4448, 106.3378'),
(33, 'Vĩnh Phúc', 3, '21.3366, 105.5911'),
(34, 'Thanh Hoá', 4, '19.8067, 105.7856'),
(35, 'Nghệ An', 4, '18.8065, 105.3510'),
(36, 'Hà Tĩnh', 4, '18.3314, 105.9091'),
(37, 'Quảng Bình', 4, '17.4731, 106.6042'),
(38, 'Quảng Trị', 4, '16.7624, 107.2030'),
(39, 'Thừa Thiên-Huế', 4, '16.4674, 107.5977'),
(40, 'Đà Nẵng', 5, '16.0471, 108.2068'),
(41, 'Quảng Nam', 5, '15.5394, 108.0195'),
(42, 'Quảng Ngãi', 5, '15.1206, 108.7922'),
(43, 'Bình Định', 5, '14.1665, 108.9027'),
(44, 'Phú Yên', 5, '13.0882, 109.0928'),
(45, 'Khánh Hoà', 5, '12.2453, 109.1943'),
(46, 'Ninh Thuận', 5, '11.5677, 108.9886'),
(47, 'Bình Thuận', 5, '11.0904, 108.0721'),
(48, 'Kon Tum', 6, '14.3498, 108.0001'),
(49, 'Gia Lai', 6, '13.9758, 108.0193'),
(50, 'Đắc Lắc', 6, '12.7100, 108.2378'),
(51, 'Đắc Nông', 6, '12.2982, 107.6919'),
(52, 'Lâm Đồng', 6, '11.5753, 108.1429'),
(53, 'Bình Phước', 7, '11.7766, 106.6860'),
(54, 'Bình Dương', 7, '11.3254, 106.7114'),
(55, 'Đồng Nai', 7, '11.0644, 107.1676'),
(56, 'Tây Ninh', 7, '11.3351, 106.1307'),
(57, 'Bà Rịa-Vũng Tàu', 7, '10.5417, 107.2429'),
(58, 'Thành phố Hồ Chí Minh', 7, '10.8231, 106.6297'),
(59, 'Long An', 8, '10.5393, 106.4228'),
(60, 'Đồng Tháp', 8, '10.6029, 105.6877'),
(61, 'Tiền Giang', 8, '10.4494, 106.3420'),
(62, 'An Giang', 8, '10.5216, 105.1259'),
(63, 'Bến Tre', 8, '10.1679, 106.5636'),
(64, 'Vĩnh Long', 8, '10.2560, 105.9661'),
(65, 'Trà Vinh', 8, '9.9235, 106.3416'),
(66, 'Hậu Giang', 8, '9.7845, 105.4709'),
(67, 'Kiên Giang', 8, '10.0080, 105.2134'),
(68, 'Sóc Trăng', 8, '9.6031, 105.9805'),
(69, 'Bạc Liêu', 8, '9.2879, 105.7213'),
(70, 'Cà Mau', 8, '9.1763, 105.1524'),
(71, 'Thành phố Cần Thơ', 8, '10.0452, 105.7469');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_location`
--
ALTER TABLE `tbl_location`
  ADD PRIMARY KEY (`locationId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_location`
--
ALTER TABLE `tbl_location`
  MODIFY `locationId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
