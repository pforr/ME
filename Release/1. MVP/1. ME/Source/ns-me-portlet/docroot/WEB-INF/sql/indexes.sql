create index IX_585597EC on ME_DANHGIABENVUNG (NAM, TRAMCAPNUOCID);
create index IX_4478E086 on ME_DANHGIABENVUNG (TRAMCAPNUOCID);

create index IX_4E0BB1CF on ME_DANHGIAVANHANH (NAM);
create index IX_C7615A93 on ME_DANHGIAVANHANH (TRAMCAPNUOCID);

create index IX_1B226E56 on ME_DAUNOINUOC (TRAMCAPNUOCID);

create index IX_6D7FA5DC on ME_KEHOACHNUOCSACH (TRAMCAPNUOCID);

create index IX_2A01F9F9 on ME_TRAMCAPNUOC (MATINH);

create index IX_2A48EFD5 on me_thongtinkiemdemnuoc (daunoinuocid);