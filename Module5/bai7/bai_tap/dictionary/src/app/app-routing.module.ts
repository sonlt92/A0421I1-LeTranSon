import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionaryComponent} from "./dictionary/dictionary.component";
import {DictionaryDetailComponent} from "./dictionary-detail/dictionary-detail.component";


const routes: Routes = [  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
