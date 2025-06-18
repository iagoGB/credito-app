import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CreditoDTO } from '../dto/credito-dto';
import { environment } from '../../../environments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class CreditoService {

  private apiUrl = `${environment.apiUrl}/creditos`;
  
  constructor(private http: HttpClient) { }

  getByNumeroNfse(numeroNfse: string): Observable<CreditoDTO[]> {
    return this.http.get<CreditoDTO[]>(`${this.apiUrl}/${numeroNfse}`);
  }

  getByNumeroCredito(numeroCredito: string): Observable<CreditoDTO[]> {
    return this.http.get<CreditoDTO[]>(`${this.apiUrl}/credito/${numeroCredito}`);
  }
}
