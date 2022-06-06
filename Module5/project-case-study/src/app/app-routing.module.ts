import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AddNewCustomerComponent} from "./customer/add-new-customer/add-new-customer.component";
import {ListCustomerComponent} from "./customer/list-customer/list-customer.component";
import {HomeComponent} from "./home/home.component";
import {ListEmployeeComponent} from "./employee/list-employee/list-employee.component";
import {ListServiceComponent} from "./service/list-service/list-service.component";
import {AddNewEmployeeComponent} from "./employee/add-new-employee/add-new-employee.component";
import {AddNewServiceComponent} from "./service/add-new-service/add-new-service.component";
import {ListUsingServiceComponent} from "./contract/list-using-service/list-using-service.component";
import {EditEmployeeComponent} from "./employee/edit-employee/edit-employee.component";
import {EditCustomerComponent} from "./customer/edit-customer/edit-customer.component";
import {EditServiceComponent} from "./service/edit-service/edit-service.component";
import {AddNewContractComponent} from "./contract/add-new-contract/add-new-contract.component";
import {AddNewContractDetailComponent} from "./contract/add-new-contract-detail/add-new-contract-detail.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer/create', component: AddNewCustomerComponent},
  {path: 'customer/show', component: ListCustomerComponent},
  {path: 'customer/edit/:id', component: EditCustomerComponent},
  {path: 'employee/show', component: ListEmployeeComponent},
  {path: 'employee/create', component: AddNewEmployeeComponent},
  {path: 'employee/edit/:id', component: EditEmployeeComponent},
  {path: 'service/create', component: AddNewServiceComponent},
  {path: 'service/showAll', component: ListServiceComponent},
  {path: 'service/edit/:id', component: EditServiceComponent},
  {path: 'contract/createContract', component: AddNewContractComponent},
  {path: 'contract/show', component: ListUsingServiceComponent},
  {path: 'contract/createContractDetail', component: AddNewContractDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
