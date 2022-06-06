import {Component, OnInit} from '@angular/core';
import {RentType} from "../../interface/rentType";
import {FormControl, FormGroup} from "@angular/forms";
import {ServiceService} from "../../services/ServiceService";
import {RentTypeService} from "../../services/RentTypeService";
import {ActivatedRoute, Router} from "@angular/router";
import {Service} from "../../interface/service";

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {
  rentTypes: RentType[] = [];
  serviceForm!: FormGroup;
  id!: string;
  service!: Service;
  rentType!: RentType;

  constructor(private _serviceService: ServiceService,
              private _rentType: RentTypeService,
              private _router: Router,
              private _activeRouter: ActivatedRoute) {
    this._activeRouter.paramMap.subscribe((param) => {
      this.id = <string>param.get('id');
      this.serviceForm = new FormGroup({
          id: new FormControl(),
          fullName: new FormControl(),
          area: new FormControl(),
          cost: new FormControl(),
          maxPeople: new FormControl(),
          idRentType: new FormControl({id: 0, name: ''}),
          numberOfFloors: new FormControl(),
          status: new FormControl(),
        }
      )
      this._serviceService.getServiceById(this.id).subscribe((data) => {
        this.service = data;
        this.serviceForm.patchValue(this.service);
      })
    })
  }

  ngOnInit(): void {
    this.getAllRentType();
  }

  onsubmit() {
    this._rentType.getServiceId(this.serviceForm.value.idRentType).subscribe((data) => {
      this.rentType = data;
      console.log(data);
      this.serviceForm.value.idRentType = this.rentType;
      this.service = this.serviceForm.value;
      this.updateService(this.service);
    })
  }

  updateService(service: Service) {
    this._serviceService.updateService(service).subscribe(() => {
      this._router.navigateByUrl('/service/showAll?msg=success').then();
    })
  }

  getAllRentType() {
    this._rentType.getAllRentTypes().subscribe((data) => {
      this.rentTypes = data;
    })
  }
}
