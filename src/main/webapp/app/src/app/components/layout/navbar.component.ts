import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { AuthService } from '../../core/services/auth.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, NgIf],
  template: `
    <nav class="p-2 bg-primary text-white flex justify-between">
      <a routerLink="/">Home</a>
      <button *ngIf="auth.getToken()" (click)="auth.logout()">Logout</button>
    </nav>
  `
})
export class NavbarComponent {
  constructor(public auth: AuthService) {}
}
