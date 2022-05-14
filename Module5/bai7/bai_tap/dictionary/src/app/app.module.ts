import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DictionayPageComponent } from './dictionay-page/dictionay-page.component';
import { DictionaryDetailComponent } from './dictionary-detail/dictionary-detail.component';
import { DictionaryComponent } from './dictionary/dictionary.component';
import {DictionaryServiceService} from "./dictionary-service.service";
import {HttpClientJsonpModule, HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    DictionayPageComponent,
    DictionaryDetailComponent,
    DictionaryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [DictionaryServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
