INSERT INTO producer (manhacungcap, tennhacungcap, sodienthoai, diachi) 
VALUES 
('ASUS', 'ASUS Technology', '0123456789', 'Taiwan'),
('LENOVO', 'Lenovo Group Ltd.', '0987654321', 'China'),
('DELL', 'Dell Technologies', '0345678912', 'USA'),
('HP', 'Hewlett-Packard', '0567891234', 'USA'),
('ACER', 'Acer Inc.', '0789123456', 'Taiwan');


-- Thêm 5 Laptop
INSERT INTO product (mamay, tenmay, soluong, gia, tenCPU, ram, xuatxu, cardmanhinh, mainboard, congsuatnguon, kichthuocman, dungluongpin, rom, loaimay, manhacungcap, dungluongluutru)
VALUES 
('LAP001', 'Laptop Gaming ASUS ROG', 10, 25990000, 'Intel Core i7-12700H', '16GB', 'Việt Nam', 'NVIDIA RTX 3050', NULL, NULL, 15.6, '6-cell 80Wh', '512GB SSD', 'Laptop', 'NC001', 512),
('LAP002', 'Laptop Dell XPS 15', 8, 32990000, 'Intel Core i9-12900HK', '32GB', 'Mỹ', 'NVIDIA RTX 3060', NULL, NULL, 15.6, '6-cell 97Wh', '1TB SSD', 'Laptop', 'NC002', 1024),
('LAP003', 'Laptop HP Envy 13', 12, 18990000, 'Intel Core i5-1240P', '16GB', 'Nhật Bản', 'Intel Iris Xe', NULL, NULL, 13.3, '4-cell 65Wh', '512GB SSD', 'Laptop', 'NC003', 512),
('LAP004', 'MacBook Pro 16', 6, 57990000, 'Apple M2 Max', '32GB', 'Mỹ', 'Apple M2 Max GPU', NULL, NULL, 16.0, '100Wh', '2TB SSD', 'Laptop', 'NC004', 2048),
('LAP005', 'Acer Predator Helios 300', 15, 27990000, 'Intel Core i7-12650H', '16GB', 'Đài Loan', 'NVIDIA RTX 3070', NULL, NULL, 17.3, '4-cell 90Wh', '1TB SSD', 'Laptop', 'NC005', 1024);

-- Thêm 5 PC
INSERT INTO product (mamay, tenmay, soluong, gia, tenCPU, ram, xuatxu, cardmanhinh, mainboard, congsuatnguon, kichthuocman, dungluongpin, rom, loaimay, manhacungcap, dungluongluutru)
VALUES 
('PC001', 'PC Gaming MSI Aegis', 5, 40990000, 'Intel Core i9-13900K', '32GB', 'Mỹ', 'NVIDIA RTX 4090', 'MSI Z690', 850, NULL, NULL, '2TB SSD', 'PC', 'NC006', 2048),
('PC002', 'PC Workstation Dell Precision', 3, 52990000, 'Intel Xeon W-2235', '64GB', 'Mỹ', 'NVIDIA Quadro RTX 5000', 'Dell Precision T7920', 1000, NULL, NULL, '4TB SSD', 'PC', 'NC007', 4096),
('PC003', 'PC Văn phòng HP ProDesk', 10, 15990000, 'Intel Core i5-12400', '8GB', 'Nhật Bản', 'Intel UHD 730', 'HP ProDesk 400 G7', 300, NULL, NULL, '512GB SSD', 'PC', 'NC008', 512),
('PC004', 'PC Gaming Razer Tomahawk', 7, 37990000, 'Intel Core i7-13700KF', '32GB', 'Mỹ', 'NVIDIA RTX 3080 Ti', 'ASUS ROG Strix Z690', 750, NULL, NULL, '1TB SSD', 'PC', 'NC009', 1024),
('PC005', 'PC Đồ họa Mac Studio', 4, 65990000, 'Apple M1 Ultra', '128GB', 'Mỹ', 'Apple M1 Ultra GPU', 'Mac Studio Board', 350, NULL, NULL, '8TB SSD', 'PC', 'NC010', 8192);
