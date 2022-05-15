import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentDetailComponent } from './student-detail/student-detail.component';
import {FormsModule} from "@angular/forms";
import { StudentListComponent } from './student-list/student-list.component';

@NgModule({
    declarations: [
        AppComponent,
        StudentDetailComponent,
        StudentListComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule
    ],
    providers: [],
    exports: [
        StudentListComponent
    ],
    bootstrap: [AppComponent]
})
export class AppModule { }
