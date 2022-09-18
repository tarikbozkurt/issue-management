import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
/* localhost/issue/.. path geldiyse buradan devam eder...*/
import { ProjectComponent } from './project.component';

const routes: Routes=[
  {
    //direkt component gözüksün diyor yönlendirme henüz yok.
    path : '',
    component: ProjectComponent
  }
];


@NgModule({
  imports : [RouterModule.forChild(routes)],
  exports : [RouterModule]
})
export class ProjectRoutingModule { }
