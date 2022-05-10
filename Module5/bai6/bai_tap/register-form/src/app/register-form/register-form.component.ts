import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";

function comparePassword(c: AbstractControl) {
  const v = c.value;
  return (v.password === v.confirmPassword) ? null : {
    passwordnotmatch: true
  };
}

@Component({
  selector: 'app-register-form',
  templateUrl: './register-form.component.html',
  styleUrls: ['./register-form.component.css']
})



export class RegisterFormComponent implements OnInit {


  registerForm: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    pwGroup: new FormGroup({password: new FormControl(''),
    confirmPassword: new FormControl('')
    }, {validators: comparePassword})
  });

  constructor(private fb: FormBuilder) {

  }
  ngOnInit(): void {
    this.registerForm.patchValue({
      email: 'letranson@drodvn.net'
    });
  }

  get validate(){
    return this.registerForm.controls;

  }
  onSubmit() {
    return this.onSubmit();
  }

}
