import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GenerateKpiComponent } from './generate-kpi.component';

const routes: Routes = [
    {
        path: '', component: GenerateKpiComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class GenerateKpiRoutingModule {
}
