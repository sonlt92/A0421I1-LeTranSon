import {AbstractControl, ValidationErrors, ValidatorFn} from "@angular/forms";

export function validAgeValidators(min: number, max: number): ValidatorFn {
  return (control: AbstractControl): ValidationErrors => {
    let birthday = new Date(control.value);
    let age = (Date.now() - birthday.getTime()) / 31536000000;
    if (age < min || age > max) {
      return {"invalidAge": true}
    }
    // @ts-ignore
    return null;
  };
}
