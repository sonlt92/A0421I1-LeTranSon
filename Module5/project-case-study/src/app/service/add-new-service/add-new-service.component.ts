import {Component, OnInit} from '@angular/core';
import {Service} from "../../interface/service";
import {RentType} from "../../interface/rentType";
import {FormControl, FormGroup} from "@angular/forms";
import {ServiceService} from "../../services/ServiceService";
import {RentTypeService} from "../../services/RentTypeService";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-new-service',
  templateUrl: './add-new-service.component.html',
  styleUrls: ['./add-new-service.component.css']
})
export class AddNewServiceComponent implements OnInit {
  rentTypes: RentType[]=[];
  serviceForm!: FormGroup;

  constructor(private _serviceService: ServiceService,
              private _rentType: RentTypeService,
              private _router: Router) {
    this.getAllRentType();
    this.serviceForm = new FormGroup({
      id: new FormControl(),
      fullName: new FormControl(),
      area: new FormControl(),
      cost: new FormControl(),
      maxPeople: new FormControl(),
      idRentType: new FormControl(),
      numberOfFloors: new FormControl(),
      status: new FormControl(),
    })
  }

  ngOnInit(): void {
  }

  onsubmit() {
    this.serviceForm.value.id = "DV-" + Math.floor(Math.random() * 1000);
    this.addNewService(this.serviceForm.value);
  }

  addNewService(service: Service) {
    this._serviceService.addNewService(service).subscribe(() => {
      this._router.navigateByUrl('/service/showAll?msg=success').then();
    })
  }

  getAllRentType() {
    this._rentType.getAllRentTypes().subscribe((data) => {
      this.rentTypes = data;
    })
  }
}
