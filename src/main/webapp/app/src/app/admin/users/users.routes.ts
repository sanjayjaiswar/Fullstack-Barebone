import { Routes } from '@angular/router';
import { UsersListComponent } from './users-list.component';
import { UserFormComponent } from './user-form.component';

export const USERS_ROUTES: Routes = [
  { path: '', component: UsersListComponent },
  { path: 'new', component: UserFormComponent },
  { path: ':id', component: UserFormComponent }
];
