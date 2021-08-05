import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ClaimListComponent } from './claim/claim-list/claim-list.component';
import { CreateClaimComponent } from './claim/create-claim/create-claim.component';
import { UpdateClaimComponent } from './claim/update-claim/update-claim.component';
const routes: Routes = [
  { path: '', component: ClaimListComponent },
  { path: 'add-claim', component: CreateClaimComponent },
  { path: 'update/:claimNo', component: UpdateClaimComponent },
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
