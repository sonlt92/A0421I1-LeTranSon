import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ContractDetailService} from "../../services/ContractDetailService";
import {ContractService} from "../../services/ContractService";
import {AttachService} from "../../interface/attachService";
import {Contract} from "../../interface/contract";
import {AttachServiceService} from "../../services/AttachServiceService";
import {Router} from "@angular/router";


@Component({
  selector: 'app-add-new-contract-detail',
  templateUrl: './add-new-contract-detail.component.html',
  styleUrls: ['./add-new-contract-detail.component.css']
})
export class AddNewContractDetailComponent implements OnInit {
  contractDetailForm!: FormGroup;
  contracts!: Contract[];
  attachService!: AttachService[];

  constructor(private _contractDetailService: ContractDetailService,
              private _contractService: ContractService,
              private _attachService: AttachServiceService,
              private _router: Router) {
    this.getAllAttachService();
    this.getAllContract();
    this.contractDetailForm = new FormGroup({
      id: new FormControl(),
      contract: new FormControl(),
      attachService: new FormControl(),
      quantity: new FormControl(),
    })
  }

  ngOnInit(): void {

  }

  onsubmit() {
    this._contractDetailService.addNewContract(this.contractDetailForm.value).subscribe(() => {
      this._router.navigateByUrl('/contract/show?msg=success').then(() => {
      });
    })
  }

  getAllContract() {
    this._contractService.getAllContract().subscribe((data) => {
      this.contracts = data;
    })
  }

  getAllAttachService() {
    this._attachService.getAllAttachService().subscribe((data) => {
      this.attachService = data;
    })
  }
}
