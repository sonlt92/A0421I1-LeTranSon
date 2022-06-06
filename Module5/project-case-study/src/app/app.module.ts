import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AddNewEmployeeComponent} from './employee/add-new-employee/add-new-employee.component';
import {ListEmployeeComponent} from './employee/list-employee/list-employee.component';
import {AddNewCustomerComponent} from './customer/add-new-customer/add-new-customer.component';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {AddNewServiceComponent} from './service/add-new-service/add-new-service.component';
import {ListServiceComponent} from './service/list-service/list-service.component';
import {AddNewContractComponent} from './contract/add-new-contract/add-new-contract.component';
import {AddNewContractDetailComponent} from './contract/add-new-contract-detail/add-new-contract-detail.component';
import {ListUsingServiceComponent} from './contract/list-using-service/list-using-service.component';
import {RegisterServiceComponent} from './contract/register-service/register-service.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {HomeComponent} from './home/home.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {EditEmployeeComponent} from './employee/edit-employee/edit-employee.component';
import {EditCustomerComponent} from './customer/edit-customer/edit-customer.component';
import {EditServiceComponent} from './service/edit-service/edit-service.component';

@NgModule({
  declarations: [
    AppComponent,
    AddNewEmployeeComponent,
    ListEmployeeComponent,
    AddNewCustomerComponent,
    ListCustomerComponent,
    AddNewServiceComponent,
    ListServiceComponent,
    AddNewContractComponent,
    AddNewContractDetailComponent,
    ListUsingServiceComponent,
    RegisterServiceComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    EditEmployeeComponent,
    EditCustomerComponent,
    EditServiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FontAwesomeModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
