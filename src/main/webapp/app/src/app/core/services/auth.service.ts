import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, tap } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private readonly tokenKey = 'token';
  user$ = new BehaviorSubject<string | null>(this.getToken());

  constructor(private http: HttpClient) {}

  login(email: string, password: string) {
    return this.http.post<{ token: string }>('/api/auth/login', { email, password }).pipe(
      tap(res => {
        localStorage.setItem(this.tokenKey, res.token);
        this.user$.next(res.token);
      })
    );
  }

  logout() {
    localStorage.removeItem(this.tokenKey);
    this.user$.next(null);
  }

  getToken() {
    return localStorage.getItem(this.tokenKey);
  }
}
