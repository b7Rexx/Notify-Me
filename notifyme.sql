-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 01, 2017 at 11:18 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `notifyme`
--

-- --------------------------------------------------------

--
-- Table structure for table `devices`
--

CREATE TABLE `devices` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `token` text NOT NULL,
  `login` varchar(50) DEFAULT 'empty'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `devices`
--

INSERT INTO `devices` (`id`, `email`, `token`, `login`) VALUES
(12, 'Smriti', 'fNPc6k-h9n8:APA91bFnqn8__Uka0fvZln9bz4fQnTmzvvCfsU23MAiql6ZX3tnvgRGZ80-0_R2odpqciAlz1UsfWnM86nh7ZXzWdBnFpqmeEEq4_GMIb9AyX3nXo6QqJpIQF2HdQy0U32E6PyOomh0h', 'asd'),
(13, 'bRexx', 'ebDlQJy2ang:APA91bH4qHHLoQ9A9DU5_ecvQ8gD5z6NoIoz-HKWIhOfYNm4SixNoS8-j0tipWGNvSLm0SPuL_edLLZ-0OO1FL427Ns7sf9x7KclRIA6U3Br0tFl3KKNM14u47tEMPpfi6e2e_xx4z7I', 'Dunot'),
(14, 'asd', 'emRAwdPd5i0:APA91bGSZg0fc6XWXzwHDU9o2R1C9BXh3H4dwEgNX3xxyr03z03yWtNW5gyIinoLJb6T__Y3P2aHrFEfrMv4T2VGU523MsUbN4Bp1Qa_8LGgQoMrx8aNg3mHU1iBA9zS043QB-2zIf__', 'asd'),
(15, 'bijen', 'cApVMtICeGA:APA91bFLrLr-qIrGwQrBtRbT2mnr-gnpzYCWM3O0Jbu_TqXtGErTOQ1ZJLO86AG1QURKUUzX6w4mgwjQjL2bE1LMc7-db7lWc6oX7jVFZqhsoUKGe3F-GKVkvfdr1NpiXV-qrkWi8mh0', 'asd'),
(16, 'RojenM', 'db0XZ03JWgw:APA91bGUEfoyLWZzX30GKKf8UEz_cb92MCGCPbsqHJWMYYzQpUE53nuUafyko5psNysW-bLXFOc0K_yDkzavK0hLkyoL6IzYzLH6cLrOu5lfS9K-QAO6NQXwMMThJrFsH4ykjvfcGUvv', 'Dunot'),
(18, 'emulator', 'fKKKYFTEVDk:APA91bGGIl58thzWruqjfQTR2f3yN0gWk_5Ushsv6tzXOTpxJzJQ5STzo5KTlyIf0l-GojV28Ts15KF5xWQhtg9NKi1LVxAf6TCTpzNhYFCJAuHvDjr-GsAThD5WNSz9odmrMHYK2-X4', 'asd'),
(22, 'cc', 'fS8WjhFOrP8:APA91bEA6gPsPv8AC2Uw8_8lTuqoRf-4a8v2uYMngVtA1Hg0zDKqY_WGB4ye08JxCXXJ47XeSVkjkSPLrA__aW7GgrAi8tSO9LeAQb81b3HmipDZZ_kRUg0BTck2dg-edJeTGHSzTUfD', 'Dunot');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `faculty` text NOT NULL,
  `roll_no` int(10) NOT NULL,
  `org_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`ID`, `Name`, `surname`, `email`, `password`, `faculty`, `roll_no`, `org_name`) VALUES
(1, 'Bijen', 'Maharjan', 'bij.maharjan@gmail.com', 'zxc123', 'BCT', 70044, '');

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `id` int(11) NOT NULL,
  `sender` varchar(100) NOT NULL,
  `subject` text NOT NULL,
  `files` mediumblob NOT NULL,
  `date` datetime NOT NULL,
  `org_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`id`, `sender`, `subject`, `files`, `date`, `org_name`) VALUES
(3, 'brexx', 'Importing WooCommerce Dummy Data', 0x346b2d616e696d652d77616c6c7061706572732d7769646573637265656e2d77616c6c70617065722d68642d31303830702e6a7067, '2017-07-16 01:07:49', 'asd'),
(4, 'brexx', 'Launch Of Application', 0x72656c69616e63652d7061696e742d70726f706f6173616c2e706466, '2017-07-16 01:30:08', 'asd'),
(5, 'brexx', 'Launch Of Application', 0x636c61737320696d6167652e6a7067, '2017-07-26 17:57:25', 'asd'),
(6, 'Business Administer', 'Importing WooCommerce Dummy Data', 0x6e6f746966796d655f6c6f676f2e706e67, '2017-07-26 19:10:37', 'asd'),
(7, 'bRexx', 'Importing WooCommerce Dummy Data', 0x3132332e6a7067, '2017-07-26 20:39:35', 'asd');

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

CREATE TABLE `notice` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `subject` text NOT NULL,
  `sender` varchar(40) NOT NULL,
  `body` text NOT NULL,
  `attachment` varchar(200) NOT NULL DEFAULT 'empty.png',
  `pin` varchar(10) NOT NULL,
  `org_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`id`, `date`, `subject`, `sender`, `body`, `attachment`, `pin`, `org_name`) VALUES
(3, '2017-07-14 13:26:33', 'Importing WooCommerce Dummy Data', 'Business Administer', 'sdkjahlkdahdhlkahsdlkhal', 'empty.png', 'No', 'asd'),
(4, '2017-07-15 00:23:38', 'Importing WooCommerce Dummy Data', 'bRexx', 'alksdjljqwjdpad', 'empty.png', 'No', 'asd'),
(5, '2017-07-16 17:18:52', 'Launch Of Application', 'bRexx', 'asdzxc', 'empty.png', 'No', 'asd'),
(6, '2017-07-16 17:22:10', 'yo', 'bRexx', 'SasZxDACdayvdijbavdJO', 'empty.png', 'Yes', 'asd'),
(8, '2017-07-22 11:20:03', 'Importing WooCommerce Dummy Data', 'Business Administer', 'akhdahjdqhwpiaklsjd', 'empty.png', 'No', 'asd'),
(10, '2017-07-22 11:27:31', 'Launch Of Application', 'brexx', 'asdzxqw', 'empty.png', 'No', 'asd'),
(11, '2017-07-22 11:28:45', 'yo', 'bRexx', 'asdaweq', 'empty.png', 'No', 'asd'),
(12, '2017-07-22 11:33:41', 'yo', 'brexx', 'asdas', 'empty.png', 'Yes', 'asd'),
(13, '2017-07-25 13:24:09', 'exam', 'dhrub', 'exam is going to be held on 15 jestha', 'empty.png', 'Yes', 'asd'),
(14, '2017-07-26 13:56:14', 'yo', 'bRexx', 'asdad', 'empty.png', 'No', 'asd'),
(15, '2017-07-26 13:56:41', 'Importing WooCommerce Dummy Data', 'brexx', 'sdascafw', 'empty.png', 'No', 'Dunot'),
(16, '2017-07-26 14:41:08', 'Holiday on 2074/04/09', 'Department of Engineering', 'On 2074/04/09, Monday, students under faculty of B.E./B. Arch are declared a leave for 1 day due to â€œWelcomeâ€ and â€œFarewellâ€.', 'empty.png', 'No', 'Dunot'),
(18, '2017-07-26 19:35:57', 'Launch Of Application', 'bRexx', 'aszxc', 'empty.png', 'No', 'asd'),
(19, '2017-07-26 21:42:27', 'Launch Of Application', 'bRexx', 'asdasd', 'empty.png', 'Yes', 'asd'),
(21, '2017-07-26 22:18:46', 'Notice', 'Department of Engineering', 'qweasdzxc', '', 'No', 'asd'),
(22, '2017-07-26 22:19:30', 'Notice', 'Department of Engineering', 'qweasdzxc', 'notifyme_logo.png', 'No', 'asd'),
(24, '2017-07-26 22:21:32', 'Launch Of Application', 'Business Administer', 'asdwef', '', 'No', 'asd'),
(25, '2017-07-26 22:26:25', 'dunot ko logo ', 'Bijen', 'logo yesto banako chu ..volii samma ma confirm garam ', '18401922_1434015326669150_6288480092082253369_o.jpg', 'No', 'Dunot'),
(26, '2017-07-26 22:28:21', 'visiting card', 'Bijen', 'check sample of the given visiting card', '18921204_1457428460994503_5593228837364463559_o.jpg', 'No', 'Dunot'),
(27, '2017-07-26 22:29:44', 'Major Project Report', 'Department of Engineering', 'Follow proper guidelines for the final report and presentation.\r\nThank You!!', '20228681_1367842113253046_7512366091545447486_n.jpg', 'Yes', 'Dunot'),
(28, '2017-07-26 23:59:37', 'Abstract', 'admin', 'The notification system designed with added features for android application to make students and teacherâ€™s communication and information at ease. The application goes by the name Notify-Me that uses push notification from admin or teachers to send notifications to students.  Push notification is the delivery of information from a software application to a computing device without a specific request from the client. The software is developed for android containing notification service as well as info on teachers and transferable notes. Notices about class occurrence and dismissals are to be informed as quickly as possible. Just by simply installation of this app users can be notified even when the app is inactive by push notification. The server on the other hand likely teachers or admin can control the particular set of user to send the notices specifically as well', '', 'Yes', 'asd'),
(29, '2017-07-27 00:00:32', 'Abstract with image', 'bRexx', 'The notification system designed with added features for android application to make students and teacherâ€™s communication and information at ease. The application goes by the name Notify-Me that uses push notification from admin or teachers to send notifications to students.  Push notification is the delivery of information from a software application to a computing device without a specific request from the client. The software is developed for android containing notification service as well as info on teachers and transferable notes. Notices about class occurrence and dismissals are to be informed as quickly as possible. Just by simply installation of this app users can be notified even when the app is inactive by push notification. The server on the other hand likely teachers or admin can control the particular set of user to send the notices specifically as well.', 'notifyme_logo.png', 'Yes', 'asd'),
(30, '2017-07-27 00:05:06', 'Test Justified', 'Business Administer', 'The notification system designed with added features for android application to make students and teacherâ€™s communication and information at ease. The application goes by the name Notify-Me that uses push notification from admin or teachers to send notifications to students.  Push notification is the delivery of information from a software application to a computing device without a specific request from the client. The software is developed for android containing notification service as well as info on teachers and transferable notes. Notices about class occurrence and dismissals are to be informed as quickly as possible. Just by simply installation of this app users can be notified even when the app is inactive by push notification. The server on the other hand likely teachers or admin can control the particular set of user to send the notices specifically as well', '20228681_1367842113253046_7512366091545447486_n.jpg', 'Yes', 'asd'),
(31, '2017-07-27 14:16:21', 'Importing WooCommerce Dummy Data', 'brexx', 'asdafqww', '18921204_1457428460994503_5593228837364463559_o.jpg', 'No', 'asd'),
(32, '2017-07-27 23:54:42', 'Launch Of Application', 'bRexx', 'At common law, notice is the fundamental principle in service of process. In this case, the service of process puts the defendant on notice of the allegations contained within the complaint, or other such pleading. Since notice is fundamental, a court may rule a pleading defective if it does not put the defendant on notice.', '', 'No', 'asd'),
(33, '2017-07-27 23:55:07', 'Launch Of Application', 'brexx', 'At common law, notice is the fundamental principle in service of process. In this case, the service of process puts the defendant on notice of the allegations contained within the complaint, or other such pleading. Since notice is fundamental, a court may rule a pleading defective if it does not put the defendant on notice.\r\n\r\nIn a civil case, personal jurisdiction over a defendant is obtained by ', '', 'No', 'asd'),
(34, '2017-07-27 23:57:07', 'Launch Of Application', 'Business Administer', 'At common law, notice is the fundamental principle in service of process. In this case, the service of process puts the defendant on notice of the allegations contained within the complaint, or other such pleading. Since notice is fundamental, a court may rule a pleading defective if it does not put the defendant on notice.\r\n\r\nIn a civil case, personal jurisdiction over a defendant is obtained by service of a summons. Service can be accomplished by personal delivery of the summons or subpoena to the person or an authorized agent of the person. Service may also be made by substituted means. for example, in many jurisdictions, service of a summons can be made on a person of suitable age and discretion at the residence or place of business of the defendant. Jurisdiction over corporations can often be obtained through a government body authorized to receive such process.\r\nDue process issues \r\n\r\nIn the United States, the right to receive notice before the government deprives an individual of a protected interest is guaranteed, along with the opportunity to be heard, by the Due Process Clauses in the Fifth and Fourteenth amendments. The Sixth Amendment also specifically guarantees the right of a criminal defendant to be notified of the charges and their grounds.\r\n\r\nIf a court bases personal jurisdiction over an out-of-state or foreign defendant on a long-arm statute, the court must carefully select a means of notifying the defendant, to comply with the notice requirement of due process. Sometimes this is done by serving agents of the defendant located within the state. Because out-of-state defendants cant always be located easily, some state or local laws may allow for service by publication. An example of this would be printing a notice of the lawsuit in a newspaper published where the defendant is believed to reside. Because the failure of a defendant to appear in court results in a default judgment against him, such measures must be sufficiently calculated to give actual notice to the defendant to satisfy due process.\r\n', '', 'No', 'asd'),
(35, '2017-07-27 23:57:31', 'Launch Of Application', 'bRexx', 'At common law, notice is the fundamental principle in service of process. In this case, the service of process puts the defendant on notice of the allegations contained within the complaint, or other such pleading. Since notice is fundamental, a court may rule a pleading defective if it does not put the defendant on notice.\r\n\r\nIn a civil case, personal jurisdiction over a defendant is obtained by service of a summons. Service can be accomplished by personal delivery of the summons or subpoena to the person or an authorized agent of the person. Service may also be made by substituted means. for example, in many jurisdictions, service of a summons can be made on a person of suitable age and discretion at the residence or place of business of the defendant. Jurisdiction over corporations can often be obtained through a government body authorized to receive such process.\r\nDue process issues \r\n\r\nIn the United States, the right to receive notice before the government deprives an individual of a protected interest is guaranteed, along with the opportunity to be heard, by the Due Process Clauses in the Fifth and Fourteenth amendments. The Sixth Amendment also specifically guarantees the right of a criminal defendant to be notified of the charges and their grounds.\r\n\r\nIf a court bases personal jurisdiction over an out-of-state or foreign defendant on a long-arm statute, the court must carefully select a means of notifying the defendant, to comply with the notice requirement of due process. Sometimes this is done by serving agents of the defendant located within the state. Because out-of-\"state\" defendants cant always be located easily, some state or local laws may allow for service by publication. An example of this would be printing a notice of the lawsuit in a newspaper published where the defendant is believed to reside. Because the failure of a defendant to appear in court results in a default judgment against him, such measures must be sufficiently calculated to give actual notice to the defendant to satisfy due process.\r\n', '', 'No', 'asd'),
(36, '2017-07-27 23:57:45', 'Launch Of Application', 'Business Administer', 'At common law, notice is the fundamental principle in service of process. In this case, the service of process puts the defendant on notice of the allegations contained within the complaint, or other such pleading. Since notice is fundamental, a court may rule a pleading defective if it does not put the defendant on notice.\r\n\r\nIn a civil case, personal jurisdiction over a defendant is obtained by service of a summons. Service can be accomplished by personal delivery of the summons or subpoena to the person or an authorized agent of the person. Service may also be made by substituted means. for example, in many jurisdictions, service of a summons can be made on a person of suitable age and discretion at the residence or place of business of the defendant. Jurisdiction over corporations can often be obtained through a government body authorized to receive such process.\r\nDue process issues \r\n\r\nIn the United States, the right to receive notice before the government deprives an individual of a protected interest is guaranteed, along with the opportunity to be heard, by the Due Process Clauses in the Fifth and Fourteenth amendments. The Sixth Amendment also specifically guarantees the right of a criminal defendant to be notified of the charges and their grounds.\r\n\r\nIf a court bases personal jurisdiction over an out-of-state or foreign defendant on a long-arm statute, the court must carefully select a means of notifying the defendant, to comply with the notice requirement of due process. Sometimes this is done by serving agents of the defendant located within the state. Because out-of-state defendants cant always be located easily, some state or local laws may allow for service by publication. An example of this would be printing a notice of the lawsuit in a newspaper published where the defendant is believed to reside. Because the failure of a defendant to appear in court results in a default judgment against him, such measures must be sufficiently calculated to give actual notice to the defendant to satisfy due process.;\r\n', '', 'No', 'asd'),
(37, '2017-07-31 16:20:49', 'yo', 'bRexx', 'asd', '123.jpg', 'No', 'Dunot'),
(38, '2017-07-31 16:21:51', 'yo', 'bRexx', 'asdzcq', '', 'No', 'Dunot'),
(40, '2017-08-01 14:58:57', 'hi', 'Business Administer', 'volii chutii\r\n', '123.jpg', 'Yes', 'asd');

-- --------------------------------------------------------

--
-- Table structure for table `organization`
--

CREATE TABLE `organization` (
  `s_n` int(11) NOT NULL,
  `org_name` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `admin_pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `organization`
--

INSERT INTO `organization` (`s_n`, `org_name`, `password`, `admin_pass`) VALUES
(7, 'Dunot', 'asdfgh', 'asdfgh'),
(8, 'asd', 'zxc', 'zxc'),
(9, 'Home', 'asd', 'asd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `devices`
--
ALTER TABLE `devices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `org_name` (`org_name`),
  ADD KEY `org_name_2` (`org_name`);

--
-- Indexes for table `organization`
--
ALTER TABLE `organization`
  ADD PRIMARY KEY (`s_n`),
  ADD KEY `s_n` (`s_n`),
  ADD KEY `s_n_2` (`s_n`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `devices`
--
ALTER TABLE `devices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `organization`
--
ALTER TABLE `organization`
  MODIFY `s_n` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
