import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../core/services/auth.service';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [FormsModule],
  template: `
    <form (ngSubmit)="submit()" class="flex flex-col gap-2 max-w-sm mx-auto mt-10">
      <input [(ngModel)]="email" name="email" placeholder="Email" class="border p-2" />
      <input [(ngModel)]="password" name="password" type="password" placeholder="Password" class="border p-2" />
      <button type="submit" class="bg-primary text-white p-2">Login</button>
    </form>
  `
})
export class LoginPageComponent {
  email = '';
  password = '';

  constructor(private auth: AuthService, private router: Router) {}

  submit() {
    this.auth.login(this.email, this.password).subscribe(() => {
      this.router.navigateByUrl('/');
    });
  }
}
