import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
/* localhost/issue/.. path geldiyse buradan devam eder...*/
import { DashboardComponent } from './dashboard.component';

const routes: Routes=[
  {
    path : '',
    component: DashboardComponent
  }
];


@NgModule({
  imports : [RouterModule.forChild(routes)],
  exports : [RouterModule]
})
export class DashboardRoutingModule { }
