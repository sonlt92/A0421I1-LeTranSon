import {BenhNhanModel} from "./benhNhanModel";

export interface BenhAnModel {
  id?:number;
  maBenhAn?: string;
  benhNhan?:BenhNhanModel;
  ngayNhapVien?: string;
  ngayRaVien?: string;
  lyDo?: string;
  phuongPhap?: string;
  bacSi?: string;
}
