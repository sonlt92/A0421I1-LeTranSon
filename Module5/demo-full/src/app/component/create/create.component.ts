import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormControl} from '@angular/forms';
import {BenhAnModel} from '../../../../../../thithuchanh/src/app/component/models/benhAnModel';
import {ComponentService} from '../../../../../../thithuchanh/src/app/component/services/component.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  createForm: FormGroup = new FormGroup({
      id: new FormControl('', [Validators.required]),
      ten_sinh_vien: new FormControl('', [Validators.required, Validators.pattern(/[^0-9/~?><.,@]$/)]),
      ten_nhom: new FormControl('', [Validators.required]),
      ten_de_tai: new FormControl('', [Validators.required]),
      chu_de: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.pattern(/^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/)]),
      so_dien_thoai: new FormControl('', [Validators.required, Validators.pattern(/^([0-9]{10}|[0-9]{12})$/)]),
  });
  sinhVien: BenhAnModel;

  constructor(private fb: FormBuilder, private service: ComponentService,
              private router: Router) {
  }
  ngOnInit(): void {}

  onSubmit(): void {
      this.service.createStudent(this.createForm.value).subscribe(
        () => {},
        (e) => {console.log(e); },
        () => {
          alert('Them thanh cong');
          this.router.navigateByUrl('/list');
      });
      console.log(this.sinhVien);
    }
  }
