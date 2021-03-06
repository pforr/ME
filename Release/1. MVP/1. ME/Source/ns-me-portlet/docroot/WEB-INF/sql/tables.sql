create table ME_BAOCAODLITONGHOP (
	ID LONG not null primary key,
	MATINH VARCHAR(75) null,
	NAM INTEGER,
	SODAUNOITHEOKEHOACH INTEGER,
	SODAUNOIMOI INTEGER,
	SONHATIEUHVSTHEOKEHOACH INTEGER,
	SONNHATIEUHVSMOI VARCHAR(75) null,
	SONGUOIHUONGLOINUOCSACH INTEGER,
	SOXA INTEGER,
	TILEHGDCONHATIEU INTEGER,
	TILEHGDCONHATIEUHVS INTEGER,
	TILETRUONGHOCHVS INTEGER,
	TILETRAMYTEHVS INTEGER,
	SONGUOIHUONGLOIVSTX INTEGER,
	KEHOACHPHEDUYET VARCHAR(75) null,
	NGAYDUYETKEHOACH DATE null,
	BAOCAOCHUONGTRINH VARCHAR(75) null,
	NGAYDANGTAI DATE null,
	NGUOILAP VARCHAR(75) null,
	SOBAOCAO VARCHAR(75) null,
	NGAYBAOCAO DATE null,
	TRANGTHAI INTEGER,
	LUUTRUPDF INTEGER,
	LUUTRUCSV INTEGER
);

create table ME_DANHGIABENVUNG (
	ID LONG not null primary key,
	TRAMCAPNUOCID INTEGER,
	NAM INTEGER,
	TRANGTHAICAPNUOC INTEGER,
	CONGXUATTHUCTE INTEGER,
	TONGDAUNOITHUCTE INTEGER,
	SONGUOICAPTHUCTE INTEGER,
	NUOCTHATTHOAT INTEGER,
	NUOCDATTIEUCHUAN INTEGER,
	NUOCCOASEN INTEGER,
	CHIPHIHOACHAT INTEGER,
	TONGCHIPHI INTEGER,
	TONGDOANHTHU INTEGER,
	NGAYTAO DATE null,
	idNguoiTao INTEGER,
	GHICHU VARCHAR(75) null,
	KETQUADANHGIA INTEGER
);

create table ME_DANHGIAVANHANH (
	ID LONG not null primary key,
	TRAMCAPNUOCID INTEGER,
	THANG INTEGER,
	NAM INTEGER,
	CONGXUATTHUCTE INTEGER,
	NUOCTHATTHOAT INTEGER,
	NUOCDATTIEUCHUAN INTEGER,
	NUOCCOASEN INTEGER,
	TRANGTHAICAPNUOC INTEGER,
	CHIPHIHOACHAT INTEGER,
	CHIPHIDIEN INTEGER,
	LUONGNHANVIEN INTEGER,
	CHIPHISUACHUA INTEGER,
	DOANHTHU INTEGER,
	NGAYTAO DATE null,
	idNguoiTao INTEGER,
	GHICHU VARCHAR(75) null
);

create table ME_DAUNOINUOC (
	ID LONG not null primary key,
	TRAMCAPNUOCID INTEGER,
	MATINH VARCHAR(75) null,
	MAHUYEN VARCHAR(75) null,
	MAXA VARCHAR(75) null,
	THONXOM VARCHAR(75) null,
	TENCHUHO VARCHAR(75) null,
	GIOITINH INTEGER,
	NGAYDAUNOIHOPDONG DATE null,
	TRANGTHAI INTEGER,
	NAMBAOCAO INTEGER,
	GHICHU VARCHAR(75) null,
	IDNGUOITAO INTEGER,
	SONGUOITRONGHO INTEGER,
	THANHPHANHOGIADINH INTEGER,
	TONGDOANHTHU INTEGER,
	KINHDO VARCHAR(75) null,
	VIDO VARCHAR(75) null,
	NGAYDAUNOITHUCTE DATE null,
	SOSERYDONGHO VARCHAR(75) null,
	DANHGIANUOCHVS VARCHAR(75) null,
	NGAYKIEMDEM DATE null,
	NGAYDANHGIA DATE null,
	IDNGUOIDANHGIA INTEGER
);

create table ME_KEHOACHNUOCSACH (
	ID LONG not null primary key,
	TRAMCAPNUOCID INTEGER,
	NAM INTEGER,
	SODAUNOIMOI INTEGER,
	SONGUOIHUONGLOI INTEGER,
	GHICHU VARCHAR(75) null
);

create table ME_TRAMCAPNUOC (
	ID LONG not null primary key,
	MATRAM VARCHAR(75) null,
	TENTRAM VARCHAR(75) null,
	MATINH VARCHAR(75) null,
	TENTINH VARCHAR(75) null,
	MAHUYEN VARCHAR(75) null,
	TENHUYEN VARCHAR(75) null,
	MAXA VARCHAR(75) null,
	TENXA VARCHAR(75) null,
	DIACHI VARCHAR(75) null,
	KINHDO VARCHAR(75) null,
	VIDO VARCHAR(75) null,
	LOAIHINH INTEGER,
	LOAIMOHINH VARCHAR(75) null,
	TENMOHINH VARCHAR(75) null,
	CONGXUATTHIETKE INTEGER,
	TONGDAUNOITHIETKE INTEGER,
	SONUOICAPTHIETKE INTEGER,
	TINHTRANGDUAN INTEGER,
	TIENDOXAYDUNG INTEGER,
	NAMXAYDUNG INTEGER,
	NAMHOANTHANH INTEGER,
	NGAYVANHANH DATE null,
	BOMAYVANHANH INTEGER,
	CHICHU VARCHAR(75) null,
	NGAYTAO DATE null,
	IDNGUOITAO LONG,
	IDNGUOIDANHGIA LONG,
	NGAYDANHGIA DATE null,
	TRANGTHAICAPNUOC INTEGER,
	CONGXUATTHUCTE INTEGER,
	TONGDAUNOITHUCTE INTEGER,
	SONGUOICAPTHUCTE INTEGER,
	TONGCHIPHI INTEGER,
	TONGDOANHTTHU INTEGER,
	NUOCDATTIEUCHUAN INTEGER,
	NUOCCOASEN INTEGER,
	NUOCTHATTHOAT INTEGER,
	TRANGTHAIDANHGIA INTEGER
);

create table me_thongtinkiemdemnuoc (
	id LONG not null primary key,
	daunoinuocid LONG,
	kehoachkiemdemnuocid INTEGER,
	matinh VARCHAR(75) null,
	mahuyen VARCHAR(75) null,
	maxa VARCHAR(75) null,
	thonxom VARCHAR(75) null,
	tenchuho VARCHAR(75) null,
	gioitinhchuho INTEGER,
	ngaykiemdem DATE null,
	hotennguoitraloi VARCHAR(75) null,
	lachuhokhong INTEGER,
	gioitinhnguoitraloi VARCHAR(75) null,
	tendantoc VARCHAR(75) null,
	kinhdo VARCHAR(75) null,
	vido VARCHAR(75) null,
	songuoitrongho INTEGER,
	thanhphanhogd INTEGER,
	chuhodungds INTEGER,
	lydokhongdungds VARCHAR(75) null,
	tenchuhohientai VARCHAR(75) null,
	gioitinhchuhohientai INTEGER,
	daunoichua INTEGER,
	anhdaunoi VARCHAR(75) null,
	thoigiandauhopdong DATE null,
	thoigiandaunoithucte DATE null,
	voinuocchaykhong INTEGER,
	nuoctrongkhong INTEGER,
	maunuoc VARCHAR(75) null,
	muinuoc VARCHAR(75) null,
	vinuoc VARCHAR(75) null,
	loaikhac VARCHAR(75) null,
	datungduckhong INTEGER,
	maunuoctungco VARCHAR(75) null,
	muinuoctungco VARCHAR(75) null,
	vinuoctungco VARCHAR(75) null,
	loaikhactungco VARCHAR(75) null,
	cobechuanuoc INTEGER,
	tinhtrangbe INTEGER,
	anhbechua VARCHAR(75) null,
	bimatnuoc INTEGER,
	solanmatnuoc INTEGER,
	sogiotrungbinh INTEGER,
	soserydongho VARCHAR(75) null,
	chisodongho VARCHAR(75) null,
	anhdongho VARCHAR(75) null,
	ghichu VARCHAR(75) null,
	daketthucdieutra INTEGER,
	lydokhonghoanthanh VARCHAR(75) null,
	imei VARCHAR(75) null,
	taikhoan VARCHAR(75) null,
	danhgiakiemdem VARCHAR(75) null
);