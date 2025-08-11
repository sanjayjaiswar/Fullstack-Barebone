import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../core/services/api.service';
import { RouterLink } from '@angular/router';

@Component({
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <h2 class="text-xl mb-2">Users</h2>
    <a routerLink="new" class="underline">Create</a>
    <ul>
      <li *ngFor="let u of users">
        {{u.email}}
      </li>
    </ul>
  `
})
export class UsersListComponent implements OnInit {
  users: any[] = [];
  constructor(private api: ApiService) {}
  ngOnInit() {
    this.api.get<any>('/api/users?page=0&size=20').subscribe(res => this.users = res.content);
  }
}
