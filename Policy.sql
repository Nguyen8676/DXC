USE [master]
GO
DROP DATABASE [Policy]
GO
/****** Object:  Database [Policy]    Script Date: 7/27/2021 11:17:53 AM ******/
CREATE DATABASE [Policy]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Policy', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Policy.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Policy_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\Policy_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Policy] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Policy].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Policy] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Policy] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Policy] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Policy] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Policy] SET ARITHABORT OFF 
GO
ALTER DATABASE [Policy] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Policy] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Policy] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Policy] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Policy] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Policy] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Policy] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Policy] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Policy] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Policy] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Policy] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Policy] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Policy] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Policy] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Policy] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Policy] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Policy] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Policy] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Policy] SET  MULTI_USER 
GO
ALTER DATABASE [Policy] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Policy] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Policy] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Policy] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Policy] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Policy]
GO
/****** Object:  Table [dbo].[Client]    Script Date: 7/27/2021 11:17:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ARITHABORT ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Client](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Client Number]  AS ('CN'+right('00000000'+CONVERT([varchar](6),[ID]),(6))) PERSISTED NOT NULL,
	[First Name] [nvarchar](60) NOT NULL,
	[Last Name] [nvarchar](60) NOT NULL,
	[Gender] [varchar](30) NOT NULL,
	[Date of Birth] [date] NOT NULL,
	[Indentity Number] [varchar](30) NOT NULL,
	[Marital Status] [varchar](30) NOT NULL,
	[Address] [nvarchar](120) NOT NULL,
	[Country] [varchar](30) NOT NULL,
 CONSTRAINT [PK_Client] PRIMARY KEY CLUSTERED 
(
	[Client Number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET ANSI_PADDING ON
GO
USE [master]
GO
ALTER DATABASE [Policy] SET  READ_WRITE 
GO

USE [Policy]
GO
SET ANSI_PADDING ON
SET IDENTITY_INSERT [dbo].[Client] ON 

INSERT [dbo].[Client] ([ID], [First Name], [Last Name], [Gender], [Date of Birth], [Indentity Number], [Marital Status], [Address], [Country]) VALUES (1, N'Luan', N'Nguyen Thanh', N'Male', CAST(N'1999-12-01' AS Date), N'175409876', N'Single', N'15 Dinh Tien Hoang', N'Vietnam')
INSERT [dbo].[Client] ([ID], [First Name], [Last Name], [Gender], [Date of Birth], [Indentity Number], [Marital Status], [Address], [Country]) VALUES (2, N'Mai', N'Bui Thi Ngoc', N'Female', CAST(N'1999-12-12' AS Date), N'165809345', N'Married', N'136 Dong Da', N'Singapore')
INSERT [dbo].[Client] ([ID], [First Name], [Last Name], [Gender], [Date of Birth], [Indentity Number], [Marital Status], [Address], [Country]) VALUES (3, N'An', N'Nguyen Thi Thinh', N'Unknown', CAST(N'1999-12-21' AS Date), N'200377765', N'Divorced', N'32 Wall Street', N'America')
INSERT [dbo].[Client] ([ID], [First Name], [Last Name], [Gender], [Date of Birth], [Indentity Number], [Marital Status], [Address], [Country]) VALUES (4, N'Nguyen', N'Vu', N'Male', CAST(N'2000-04-30' AS Date), N'340989875', N'Single', N'03 Washington', N'America')
SET IDENTITY_INSERT [dbo].[Client] OFF
SET ANSI_PADDING OFF


GO
USE [Policy]
GO
CREATE TABLE [dbo].[Motor](
	[ID] [INT] IDENTITY(1,1) NOT NULL,
	[Policy No] AS ('MT'+right('00000000'+CONVERT([varchar](6),[ID]),(6))) PERSISTED NOT NULL,
	[Inception Date] [DATE] NOT NULL,
	[Expiry Date] [DATE] NOT NULL,
	[Policy Owner] [VARCHAR](8) NOT NULL,
	[Engine No] [VARCHAR](30) NOT NULL,
	[Chassis No] [VARCHAR](30) NOT NULL,
	[Vehicle Registration No] [VARCHAR](30) NOT NULL,
	[Billing Currency] [VARCHAR](30) NOT NULL,
	[Sum Insured] [NUMERIC](17,2) NOT NULL,
	[Rate] [NUMERIC](7,5) NOT NULL,
	[Annual Premium] [NUMERIC](17,2) NULL,
	[Posted Premium] [NUMERIC](17,2) NULL,
	CONSTRAINT [PK_Motor] PRIMARY KEY CLUSTERED 
(
	[Policy No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Motor]
ADD FOREIGN KEY ([Policy Owner]) REFERENCES [dbo].[Client]([Client Number]);
SET ANSI_PADDING ON
GO
USE [master]
GO
ALTER DATABASE [Policy] SET  READ_WRITE
GO

GO
USE [Policy]
GO
drop table Claim;

CREATE TABLE [dbo].[Claim](
	[ID] [INT] IDENTITY(1,1) NOT NULL,
	[Claim No] AS ('CL'+right('00000000'+CONVERT([varchar](6),[ID]),(6))) PERSISTED NOT NULL,
	[Policy No] [VARCHAR](8) NOT NULL,
	[Date Occurred] [DATE] NOT NULL,
	[Reserve Currency] [VARCHAR](30) NOT NULL,
	[Reserve Amount] [NUMERIC](17,2) NOT NULL,
	CONSTRAINT [PK_Claim] PRIMARY KEY CLUSTERED
(
	[Claim No] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

ALTER TABLE Claim
add Status BIT;

USE [Policy]
GO
SET ANSI_PADDING ON
SET IDENTITY_INSERT [dbo].[Claim] ON
INSERT [dbo].[Claim] ([ID],[Policy No],[Date Occurred],[Reserve Currency],[Reserve Amount],[Status])
		VALUES (1, N'MT000001',CAST(N'2019-12-02' AS Date), N'VND',
		10000000.00,0)
SET IDENTITY_INSERT [dbo].[Claim] OFF
SET ANSI_PADDING OFF

GO
ALTER TABLE [dbo].[Claim]
ADD FOREIGN KEY ([Policy No]) REFERENCES [dbo].[Motor]([Policy No]);
SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Message]
(
    ID int IDENTITY  NOT NULL,
    ErrMessage nvarchar(255) NOT NULL,
    PRIMARY KEY (ID)
)

INSERT [dbo].[Message] ([ErrMessage])
		VALUES ( N'Policy does not exist')
INSERT [dbo].[Message] ([ErrMessage])
		VALUES ( N'This is a mandatory field')

INSERT [dbo].[Message] ([ErrMessage])
		VALUES ( N'Must not be greater than Sum Insured')



USE [master]
GO
ALTER DATABASE [Policy] SET  READ_WRITE 
GO

USE [Policy]
GO
SET ANSI_PADDING ON
SET IDENTITY_INSERT [dbo].[Motor] ON

INSERT [dbo].[Motor] ([ID], [Inception Date], [Expiry Date], [Policy Owner],
		[Engine No], [Chassis No], [Vehicle Registration No], [Billing Currency],
		[Sum Insured], [Rate], [Annual Premium], [Posted Premium])
		VALUES (1,CAST(N'2019-12-01' AS Date), CAST(N'2021-12-01' AS Date), N'CN000001', N'1325ACEW',
		N'C1411MF',N'51H-791.02', N'VND', 10000000.00, 0.1, 0, 0)
INSERT [dbo].[Motor] ([ID], [Inception Date], [Expiry Date], [Policy Owner],
		[Engine No], [Chassis No], [Vehicle Registration No], [Billing Currency],
		[Sum Insured], [Rate], [Annual Premium], [Posted Premium])
		VALUES (2,CAST(N'2020-12-01' AS Date), CAST(N'2021-7-24' AS Date), N'CN000002', N'8723DWAB',
		N'A4461FE',N'489B1-795.43', N'VND', 40000000.00, 0.1, 0, 0)
INSERT [dbo].[Motor] ([ID], [Inception Date], [Expiry Date], [Policy Owner],
		[Engine No], [Chassis No], [Vehicle Registration No], [Billing Currency],
		[Sum Insured], [Rate], [Annual Premium], [Posted Premium])
		VALUES (3,CAST(N'2018-4-01' AS Date), CAST(N'2020-2-01' AS Date), N'CN000003', N'2245MNPQ',
		N'B8911CN',N'47L3-2228', N'VND', 20000000.00, 0.1, 0, 0)
INSERT [dbo].[Motor] ([ID], [Inception Date], [Expiry Date], [Policy Owner],
		[Engine No], [Chassis No], [Vehicle Registration No], [Billing Currency],
		[Sum Insured], [Rate], [Annual Premium], [Posted Premium])
		VALUES (4,CAST(N'2017-11-01' AS Date), CAST(N'2019-6-17' AS Date), N'CN000004', N'9803CEOW',
		N'G9411PQ',N'99H-796.09', N'VND', 36000000.00, 0.1, 0, 0)
INSERT [dbo].[Motor] ([ID], [Inception Date], [Expiry Date], [Policy Owner],
		[Engine No], [Chassis No], [Vehicle Registration No], [Billing Currency],
		[Sum Insured], [Rate], [Annual Premium], [Posted Premium])
		VALUES (5,CAST(N'2019-5-05' AS Date), CAST(N'2021-2-05' AS Date), N'CN000003', N'7749TDMA',
		N'D0283MF',N'49H-7919', N'VND', 25000000.00, 0.1, 0, 0)

SET IDENTITY_INSERT [dbo].[Motor] OFF
SET ANSI_PADDING OFF





