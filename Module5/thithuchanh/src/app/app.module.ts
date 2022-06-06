import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {ComponentModule} from './component/component.module';
import {HttpClientModule} from '@angular/common/http';
import {MaterialModule} from './material/material.module';
import {ReactiveFormsModule} from '@angular/forms';
import {DeleteComponent} from './component/delete/delete.component';
import {ListComponent} from './component/list/list.component';

@NgModule({
  declarations: [
    AppComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        ComponentModule,
        HttpClientModule,
        MaterialModule,
        ReactiveFormsModule,
    ],
  providers: [ListComponent,DeleteComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
