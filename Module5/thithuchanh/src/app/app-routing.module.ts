import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {DeleteComponent} from './component/delete/delete.component';
import {ListComponent} from './component/list/list.component';

const routes: Routes = [
  {
    path: '', children: [

      {path: 'delete/:id', component: DeleteComponent},
      {path: 'list', component: ListComponent}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
