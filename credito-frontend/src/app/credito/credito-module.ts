import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CreditoRoutingModule } from './credito-routing-module';
import { Listagem } from './listagem/listagem';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreditoService } from './service/credito-service';
import { HttpClient } from '@angular/common/http';
import { NgbAlertModule, NgbDropdownModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';




@NgModule({
  declarations: [Listagem],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CreditoRoutingModule,
    NgbDropdownModule,
    NgbAlertModule,
    NgbModule
  ], 
  providers: [
    CreditoService,
    HttpClient
  ]
})
export class CreditoModule { }
