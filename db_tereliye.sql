CREATE DATABASE db_tereliye;
USE db_tereliye;

-- Tabel utama untuk menyimpan data buku
CREATE TABLE tbl_buku (
  id_buku INT AUTO_INCREMENT PRIMARY KEY,
  judul VARCHAR(100) NOT NULL,
  genre VARCHAR(50),
  harga INT,
  stok INT
);

-- Isi data awal
INSERT INTO tbl_buku (judul, genre, harga, stok) VALUES
('Hujan', 'Fiksi', 85000, 10),
('Pulang', 'Drama', 90000, 7),
('Bumi', 'Fantasi', 95000, 12),
('Rindu', 'Religi', 88000, 5);

-- Tabel backup otomatis
CREATE TABLE tbl_backup (
  id_backup INT AUTO_INCREMENT PRIMARY KEY,
  id_buku INT,
  judul VARCHAR(100),
  genre VARCHAR(50),
  harga INT,
  stok INT,
  waktu_backup TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
