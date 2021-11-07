USE [master]
GO
/****** Object:  Database [FU_DB]    Script Date: 11/2/2021 9:25:25 AM ******/
CREATE DATABASE [FU_DB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'FU_DB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\FU_DB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'FU_DB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\FU_DB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [FU_DB] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [FU_DB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [FU_DB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FU_DB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FU_DB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FU_DB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FU_DB] SET ARITHABORT OFF 
GO
ALTER DATABASE [FU_DB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [FU_DB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FU_DB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FU_DB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FU_DB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FU_DB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FU_DB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FU_DB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FU_DB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FU_DB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [FU_DB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FU_DB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FU_DB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FU_DB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FU_DB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FU_DB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FU_DB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FU_DB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [FU_DB] SET  MULTI_USER 
GO
ALTER DATABASE [FU_DB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FU_DB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [FU_DB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [FU_DB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [FU_DB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [FU_DB] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [FU_DB] SET QUERY_STORE = OFF
GO
USE [FU_DB]
GO
/****** Object:  Table [dbo].[Stocks]    Script Date: 11/2/2021 9:25:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Stocks](
	[StockID] [int] NOT NULL,
	[StockName] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[DateAvailable] [nvarchar](50) NOT NULL,
	[Note] [nvarchar](50) NULL,
 CONSTRAINT [PK_Stocks] PRIMARY KEY CLUSTERED 
(
	[StockID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [FU_DB] SET  READ_WRITE 
GO
