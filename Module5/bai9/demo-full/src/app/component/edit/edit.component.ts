import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ComponentService} from '../services/component.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {SinhVienModel} from '../models/sinhVienModel';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  editForm: FormGroup;
  sinhVien: SinhVienModel;
  constructor(private fb: FormBuilder, private service: ComponentService,
              private router: Router, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const id = Number(paramMap.get('id'));
      this.service.findById(id).subscribe(next => {
        this.sinhVien = next;
        this.editForm.patchValue({
          id: this.sinhVien.id,
          ten_sinh_vien: this.sinhVien.ten_sinh_vien,
          email: this.sinhVien.email,
          ten_de_tai: this.sinhVien.ten_de_tai,
          so_dien_thoai: this.sinhVien.so_dien_thoai,
          chu_de: this.sinhVien.chu_de,
          ten_nhom: this.sinhVien.ten_nhom
        });
      });
    });
    this.editForm = this.fb.group({
      id: ['', Validators.required],
      ten_sinh_vien: ['', [Validators.required, Validators.pattern(/[^0-9/~?><.,@]$/)]],
      email: ['', [Validators.required, Validators.pattern(/^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/)]],
      ten_de_tai: ['', Validators.required],
      so_dien_thoai: ['', [Validators.required, Validators.pattern(/^([0-9]{10}|[0-9]{12})$/)]],
      chu_de: ['', Validators.required],
      ten_nhom: ['', [Validators.required]]
    });
  }

  onSubmit(): void {
    console.log(this.editForm);
    if (this.editForm.valid) {
      this.sinhVien = this.editForm.value;
      this.service.updateStudent(this.sinhVien).subscribe(next => this.router.navigateByUrl('/list'));
    }
  }
}
