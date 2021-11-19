create database `furama-resort`;

use database_furama;


create table kieu_thue(
id_kieu_thue int primary key,
ten_kieu_thue varchar(45),
gia int
);

create table loai_dich_vu(
id_loai_dich_vu int primary key,
ten_loai_dich_vu varchar(45)
);

create table dich_vu(
id_dich_vu int primary key,
ten_dich_vu varchar(30),
dien_tich int,
so_tang int,
so_nguoi_toi_da int,
chi_phi_thue int,
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai varchar(30),
foreign key (id_kieu_thue) references kieu_thue (id_kieu_thue),
foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);

create table trinh_do(
id_trinh_do int primary key,
ten_trinh_do varchar(45)
);

create table vi_tri(
id_vi_tri int primary key,
ten_vi_tri varchar(45)
);

create table bo_phan(
id_bo_phan int primary key,
ten_bo_phan varchar(30)
);

create table nhan_vien(
id_nhan_vien int primary key,
ho_va_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmnd varchar(9),
luong int,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key(id_vi_tri) references vi_tri(id_vi_tri),
foreign key(id_trinh_do) references trinh_do(id_trinh_do),
foreign key(id_bo_phan) references bo_phan(id_bo_phan)
);

create table loai_khach(
id_loai_khach int primary key,
ten_loai_khach varchar(45)
);

create table khach_hang(
id_khach_hang int primary key,
id_loai_khach int,
ho_va_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(9),
sdt varchar(10),
email varchar(45),
dia_chi varchar(45),
foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int primary key,
ten_dich_vu varchar(45),
don_vi varchar(45),
gia_tien int,
trang_thai_kha_dung varchar(45)
);

create table hop_dong(
id_hop_dong int primary key,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien) on delete cascade,
foreign key (id_khach_hang) references khach_hang(id_khach_hang),
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int primary key,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
foreign key (id_hop_dong) references hop_dong(id_hop_dong) on delete cascade,
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);

-- them moi vi tri nhan vien 

insert into vi_tri
values('1','Lễ tân'),
('2','Phục vụ'),
('3','Chuyên viên'),
('4','Giám sát'),
('5','Quản lý'),
('6','Giám đốc');

-- them moi bo phan nhan vien-- 

insert into bo_phan
values('1','Sale-Marketing'),
('2','Hành chính'),
('3','Phục vụ'),
('4','Quản lý');

-- them moi trinh do nhan vien

insert into trinh_do
values('1','Trung cấp'),
('2','Cao đẳng'),
('3','Đại học'),
('4','Sau đại học');

-- Thêm mới thông tin nhân viên

insert into nhan_vien
values('1','1','1','1','1992-06-29','12345689','700000','0916309250','letranson1992@gmail.com','Quảng bình','Lê Trần Sơn'),
('2','2','2','2','1998-03-07','12345689','700000','0916309250','nguyen@gmail.com','Quảng bình','Nguyễn Văn Sang'),
('3','3','3','3','1999-03-08','12345689','700000','0916309250','thu@gmail.com','Đăk-Lăk','Ngô Thị Hoài Anh'),
('4','4','4','4','1999-03-09','12345689','700000','0916309250','trang@gmail.com','Long an','Lý Thuỳ Trang'),
('5','4','4','4','1999-03-09','12345689','700000','0916309250','hai@gmail.com','Quảng Ngãi','Trương Quang Hai'),
('6','4','4','4','1999-03-09','12345689','700000','0916309250','trang@gmail.com','Quảng nam','Trần Thị Huệ'),
('7','6','4','4','1999-03-20','12345689','700000','0916309250','ha@gmail.com','Quảng ngãi','Trương Thị Thúy Hạ'),
('8','1','1','1','1999-03-11','12345689','700000','0916309250','nhan2@gmail.com','đà nẵng','Khánh'),
('9','2','2','2','1998-03-07','12345689','700000','0916309250','nguyen@gmail.com','Quảng bình','Hồng');

-- Thêm mới loại khách hàng

insert into loai_khach
values('1','Diamond'),
('2','Platinium'),
('3','Gold'),
('4','Silver'),
('5','Member');

-- Thêm mới thông tin khach hàng

insert into Khach_hang
values('1','1','Nguyễn thị thanh','1997-03-15','123456789','0916309250','thanh@gnail.com','Đà nẵng'),
('2','4','Nguyễn văn thịnh','1999-03-15','123456789','0916309250','thinh@gnail.com','Quảng ngãi'),
('3','2','Hoàng hồng','2001-08-15','123456789','0916309250','hong@gnail.com','Quảng bình'),
('4','3','Ngô thị mỹ duyên','1998-03-15','123456789','0916309250','duyen@gnail.com','Quảng bình'),
('5','1','Nguyễn thị thu thủy','1985-11-15','123456789','0916309250','thuy@gnail.com','Đà nẵng'),
('6','1','Hồng','1997-03-15','123456789','0916309250','thanh@gnail.com','Đà nẵng'),
('7','4','Khánh','1999-03-15','123456789','0916309250','thinh@gnail.com','Quảng ngãi'),
('8','4','Thu','1999-03-15','123456789','0916309250','thinh@gnail.com','Quảng ngãi'),
('9','2','Hồng','1999-03-15','325545','5454545','tanh@gnail.com','Quang binh'),
('10','1','Nguyễn thị thanh','1997-03-15','123456789','0916309250','thanh@gnail.com','Vinh'),
('11','1','Nguyễn văn thịnh','1999-03-15','123456789','0916309250','thinh@gnail.com','Quảng ngãi'),
('12','1','Hoàng hồng','2001-08-15','123456789','0916309250','hong@gnail.com','Quảng ngãi');

-- Thêm mới loại dịch vụ

insert into Loai_dich_vu
values('1','Villa'),
('2','House'),
('3','Room');

-- thêm mới kiêu thuê

insert into kieu_thue
values('1','Năm','500000'),
('2','Tháng','200000'),
('3','Ngày','10000'),
('4','Giờ','500');

-- Thêm mới dịch vụ

insert into dich_vu
values('1','Villa 1','500','2','6','50000','1','2','còn phòng'),
('2','house1','500','2','6','50000','2','3','còn phòng'),
('3','Villa 2','500','2','6','50000','1','2','còn phòng'),
('4','Room1','500','2','6','50000','3','3','còn phòng'),
('5','house 2','500','2','6','50000','2','2','còn phòng'),
('6','Villa 3','500','2','6','50000','1','2','còn phòng');

-- Thêm dịch vụ đi kèm

insert into dich_vu_di_kem
values('1','Massage','người','200','còn trống'),
('2','Karaoke','giờ','50','còn trống'),
('3','Thức ăn','Phần','70','còn'),
('4','Nước uống','ly','15','còn'),
('5','Tham quan','người','200','còn trống');

-- Thêm mới hợp đồng

insert into	hop_dong
values('1','1','1','1','2021-11-02','2021-11-07','5005','700000'),
('2','4','4','3','2021-11-02','2021-11-07','5005','700000'),
('3','2','2','2','2021-11-02','2021-11-07','5005','700000'),
('4','5','3','1','2021-11-02','2021-11-07','5005','700000');

insert into	hop_dong
values('5','1','1','1','2021-11-02','2021-11-07','5005','700000'),
('6','1','4','3','2021-11-02','2021-11-07','5005','700000'),
('7','2','2','1','2021-11-02','2021-11-07','5005','700000'),
('8','5','3','1','2021-11-02','2021-11-07','5005','700000');

insert into	hop_dong
values('9','1','6','1','2021-11-02','2021-11-07','5005','700000'),
('10','1','6','3','2021-11-02','2021-11-07','5005','700000'),
('11','2','6','1','2021-11-02','2021-11-07','5005','700000');

insert into	hop_dong
values('12','1','6','1','2018-11-02','2021-11-07','5005','700000'),
('13','1','6','3','2018-11-02','2021-11-07','5005','700000');

insert into	hop_dong
values('14','4','1','1','2019-11-02','2021-11-07','5005','700000'),
('15','3','2','3','2019-11-02','2021-11-07','5005','700000');

insert into	hop_dong
values('16','4','10','1','2019-11-02','2021-11-07','5005','700000'),
('17','3','11','3','2019-11-02','2021-11-07','5005','700000'),
('18','3','12','3','2019-11-02','2021-11-07','5005','700000');

-- Thêm mới hợp đồng chi tiết

insert into hop_dong_chi_tiet
values('1','1','2','3'),
('2','2','3','3'),
('3','3','1','5'),
('4','4','4','4');

insert into hop_dong_chi_tiet
values('5','16','2','3'),
('6','17','3','3'),
('7','18','1','5'),
('8','16','4','4');

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.

select*
from nhan_vien 
where (ho_va_ten like't%'or ho_va_ten like 'k%' or ho_va_ten like 'h%')and(length(ho_va_ten)<=15);

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select*
from khach_hang
where   ((year(curdate())-year(ngay_sinh)) >=18) and ((year(curdate())-year(ngay_sinh))<= 50) and (dia_chi="Đà nẵng" or dia_chi="Quảng trị");

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select k.id_loai_khach,k.id_khach_hang,k.ho_va_ten,count(h.id_khach_hang) 'count'
from khach_hang k
	right join hop_dong h on k.id_khach_hang = h.id_khach_hang
    left join loai_khach l on k.id_loai_khach = l.id_loai_khach
    where l.ten_loai_khach = 'Diamond'
    group by h.id_khach_hang
    order by count ;
    
-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select k.id_khach_hang, k.ho_va_ten, l.ten_loai_khach, h.id_hop_dong, d.ten_dich_vu, h.ngay_lam_hop_dong, h.ngay_ket_thuc,
(d.chi_phi_thue + hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia_tien) 'tong_tien'
from khach_hang k
	left join loai_khach l on k.id_loai_khach = l.id_loai_khach
    left join hop_dong h on k.id_khach_hang = h.id_khach_hang
    left join dich_vu d on h.id_dich_vu = d.id_dich_vu
    left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong_chi_tiet=hop_dong_chi_tiet.id_hop_dong_chi_tiet
    right join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem= dich_vu_di_kem.id_dich_vu_di_kem
    group by id_khach_hang;
    
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
    
select id_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, loai_dich_vu.ten_loai_dich_vu
from dich_vu
	left join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
    where dich_vu.id_dich_vu not in (
     select id_dich_vu
     from hop_dong
     where id_dich_vu is not null and month(hop_dong.ngay_lam_hop_dong)>=1 and month(hop_dong.ngay_lam_hop_dong)<=3);
     
-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.

select id_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
from dich_vu
	left join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
 where dich_vu.id_dich_vu not in (
     select id_dich_vu
     from hop_dong
     where id_dich_vu is not null and year((hop_dong.ngay_lam_hop_dong))=2019)
     and  dich_vu.id_dich_vu in (
     select id_dich_vu
     from hop_dong
     where id_dich_vu is not null and year((hop_dong.ngay_lam_hop_dong))=2018);
     
-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau. Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

select distinct ho_va_ten
from khach_hang;

select ho_va_ten
from khach_hang
	group by ho_va_ten;

select ho_va_ten
from khach_hang
	where ho_va_ten not in(
    select ho_va_ten
    from khach_hang
    where ho_va_ten is not null
    group by ho_va_ten
    having count(ho_va_ten)>1);
    
-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select thang.month, count(hop_dong.ngay_lam_hop_dong) as so_luong_dang_ky, sum(hop_dong.tong_tien)
from(select 1 as month
union select 2 as month
union select 3 as month
union select 4 as month
union select 5 as month
union select 6 as month
union select 7 as month
union select 8 as month
union select 9 as month
union select 10 as month
union select 11 as month
union select 12 as month) as thang
	left join hop_dong on month(hop_dong.ngay_lam_hop_dong)=thang.month
    where hop_dong.id_khach_hang in(
    select id_khach_hang
    from hop_dong
    where id_khach_hang is not null) and year(ngay_lam_hop_dong)=2019 or  year(ngay_lam_hop_dong) is null or  month(ngay_lam_hop_dong) is null
    group by thang.month;

select month(ngay_lam_hop_dong), count(hop_dong.ngay_lam_hop_dong)
from hop_dong
	where id_khach_hang in(
    select id_khach_hang
    from hop_dong
    where id_khach_hang is not null) and year(ngay_lam_hop_dong)=2019
    group by hop_dong.ngay_lam_hop_dong;
    
-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

select hop_dong.id_hop_dong, ngay_lam_hop_dong , ngay_ket_thuc, tien_dat_coc, count(hop_dong_chi_tiet.id_dich_vu_di_kem)
from hop_dong
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong;
 
 -- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
 
select dich_vu_di_kem.id_dich_vu_di_kem, ten_dich_vu, don_vi, gia_tien, trang_thai_kha_dung, ho_va_ten, ten_loai_khach, khach_hang.dia_chi
from dich_vu_di_kem
	left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
    left join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
    left join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
    left join loai_khach on loai_khach.id_loai_khach = khach_hang.id_loai_khach
   where loai_khach.ten_loai_khach = 'Diamond' and (khach_hang.dia_chi='Vinh' or khach_hang.dia_chi = 'Quảng ngãi');
   
   -- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng
   -- cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select hop_dong.id_hop_dong, nhan_vien.ho_va_ten as nhan_vien, khach_hang.ho_va_ten as khach_hang,
 khach_hang.sdt, dich_vu.ten_dich_vu, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_luong_dich_vu_di_kem,sum(hop_dong.tien_dat_coc)
from hop_dong
	left join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
    left join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
    left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
    left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
    left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
    where not exists( select hop_dong.id_hop_dong where hop_dong.ngay_lam_hop_dong between '2019-01-01' and '2019-06-31')
    and exists( select hop_dong.id_hop_dong where hop_dong.ngay_lam_hop_dong between '2019-10-01' and '2019-12-31')
    group by hop_dong.id_dich_vu;
    
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
create temporary table temp
select dich_vu_di_kem.id_dich_vu_di_kem, ten_dich_vu, don_vi, gia_tien , count(hop_dong_chi_tiet.id_dich_vu_di_kem)
from dich_vu_di_kem
 left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
 group by hop_dong_chi_tiet.id_dich_vu_di_kem;
 select*from temp;
 
 -- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
 
 select hop_dong_chi_tiet.id_hop_dong, dich_vu_di_kem.ten_dich_vu, count(dich_vu_di_kem.id_dich_vu_di_kem) as so_lan_su_dung
 from dich_vu_di_kem
	left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
 group by hop_dong_chi_tiet.id_dich_vu_di_kem
 having so_lan_su_dung = 1;
 
 -- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
 
 select nhan_vien.id_nhan_vien, ho_va_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan, so_dien_thoai, dia_chi, count(id_hop_dong) as so_hop_dong
 from nhan_vien
	left join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
    inner join trinh_do on trinh_do.id_trinh_do = nhan_vien.id_trinh_do
    inner join bo_phan on bo_phan.id_bo_phan = nhan_vien.id_bo_phan
    where year(hop_dong.ngay_lam_hop_dong)>=2018 and year(hop_dong.ngay_lam_hop_dong)<=2018
    group by id_nhan_vien
    having so_hop_dong <=3;
    
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.;

delete from nhan_vien
where id_nhan_vien not in (
 select hop_dong.id_nhan_vien
 from hop_dong
 where id_nhan_vien is not null and (year(hop_dong.ngay_lam_hop_dong)>=2017 and year(hop_dong.ngay_lam_hop_dong)<=2019)
 group by hop_dong.id_nhan_vien);

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.

update khach_hang , (select hop_dong.id_khach_hang as id, sum(hop_dong.tong_tien) as tong_tien from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = 2019
group by hop_dong.id_khach_hang
having tong_tien >= 10000) as temp
set khach_hang.id_loai_khach = (select loai_khach.id_loai_khach from loai_khach where loai_khach.ten_loai_khach = "Diamond")
where khach_hang.id_loai_khach = (select loai_khach.id_loai_khach from loai_khach where loai_khach.ten_loai_khach = "Platinium")
and temp.id = khach_hang.id_khach_hang;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).

delete from hop_dong
where year(hop_dong.ngay_lam_hop_dong)>2016;

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi

update dich_vu_di_kem , (select hop_dong_chi_tiet.id_dich_vu_di_kem as id, count(hop_dong_chi_tiet.id_dich_vu_di_kem) as so_lan from hop_dong_chi_tiet
group by hop_dong_chi_tiet.id_dich_vu_di_kem
having so_lan>10)as temp
set dich_vu_di_kem.gia_tien = dich_vu_di_kem.gia_tien*2
where temp.id = dich_vu_di_kem.id_dich_vu_di_kem;

-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

select nhan_vien.id_nhan_vien as id, nhan_vien.ho_va_ten as ho_va_ten, nhan_vien.email as email, nhan_vien.so_dien_thoai as so_dien_thoai, nhan_vien.ngay_sinh as ngay_sinh, nhan_vien.dia_chi as dia_chi
from nhan_vien
union all
select khach_hang.id_khach_hang as id, khach_hang.ho_va_ten as ho_va_ten, khach_hang.email as email, khach_hang.sdt as so_dien_thoai, khach_hang.ngay_sinh as ngay_sinh, khach_hang.dia_chi as dia_chi
from khach_hang;

 
