import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CreditoService } from '../service/credito-service';
import { CreditoDTO } from '../dto/credito-dto';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.html',
  styleUrl: './listagem.css',
  standalone: false
})
export class Listagem {

  consulta: Observable<CreditoDTO[]> | undefined;
  opcoesFiltro = ['NFS-e', 'Crédito'];
  creditos: CreditoDTO[] = [];
  formularioSubmetido = false;
  carregando: boolean = false;

  formularioPesquisa = new FormGroup({
    tipo: new FormControl('', Validators.required),
    valor: new FormControl('',  Validators.required)
  });
  

  constructor(
    private creditoService: CreditoService
  ){}

  selecionar(valor: string){
    this.formularioPesquisa.get('tipo')?.setValue(valor);
  }

  pesquisarNfes() {
    this.formularioSubmetido = true;
    if (this.formularioPesquisa.valid) {
      this.carregando = true;
      if (this.tipoSelecionado === 'NFS-e') {
        this.consulta = this.creditoService.getByNumeroNfse(this.valorInformado);
      } else {
        this.consulta = this.creditoService.getByNumeroCredito(this.valorInformado);
      }

      this.consulta.subscribe(values => {
        this.creditos = values;
        this.carregando = false;
      });
    }

  }

  get tipoSelecionado() {
    return this.formularioPesquisa.get('tipo')?.value ?? '';
  }

  get valorInformado() {
    return this.formularioPesquisa.get('valor')?.value ?? '';
  }

  onCloseAlert() {
    this.formularioSubmetido = false;
  }
}
