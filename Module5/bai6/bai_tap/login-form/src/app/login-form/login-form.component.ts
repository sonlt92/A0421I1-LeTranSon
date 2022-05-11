import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  registerForm: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  });

  isSubmit: boolean = false;

  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.isSubmit = true;
    if (this.registerForm.invalid) {
      return;
    }
    alert("Login success")
  }

}
