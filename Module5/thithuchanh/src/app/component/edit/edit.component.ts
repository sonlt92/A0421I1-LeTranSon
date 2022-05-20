import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ComponentService} from '../services/component.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {BenhAnModel} from '../models/benhAnModel';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  editForm: FormGroup;
  benhVien: BenhAnModel;
  constructor(private fb: FormBuilder, private service: ComponentService,
              private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = Number(paramMap.get('id'));
      this.service.findById(id).subscribe(next => {
        this.benhVien = next;
        this.editForm.patchValue({
          id: this.benhVien.id,
          ma_benh_an: this.benhVien.ma_benh_an,
          ma_benh_nhan: this.benhVien.ma_benh_nhan,
          ten_benh_nhan: this.benhVien.ten_benh_nhan,
          ngay_nhap_vien: this.benhVien.ngay_nhap_vien,
          ngay_ra_vien: this.benhVien.ngay_ra_vien,
          ly_do: this.benhVien.ly_do,
          phuong_phap: this.benhVien.phuong_phap,
          bac_si: this.benhVien.bac_si
        });
      });
    });
    this.editForm = this.fb.group({
      id: ['', Validators.required],
      ma_benh_an: ['', Validators.required],
      ma_benh_nhan: ['', Validators.required],
      ten_benh_nhan: ['', Validators.required],
      ngay_nhap_vien: ['', Validators.required],
      ngay_ra_vien: ['', Validators.required],
      ly_do: ['', [Validators.required]],
      phuong_phap: ['', [Validators.required]],
      bac_si: ['', [Validators.required]]
    });
  }

  onSubmit(): void {
    console.log(this.editForm);
    if (this.editForm.valid) {
      this.benhVien = this.editForm.value;
      this.service.updateBenhAn(this.benhVien).subscribe(next => this.router.navigateByUrl('/list'));
    }
  }
}
