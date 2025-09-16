import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Greeting {
   private apiUrl = 'http://localhost:8082/consume';

  constructor(private http: HttpClient) {}

  getGreeting(): Observable<string> {
    return this.http.get(this.apiUrl, { responseType: 'text' });
  }
}
