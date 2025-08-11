import { Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page.component';
import { LoginPageComponent } from './pages/login-page.component';
import { AuthGuard } from './core/guards/auth.guard';
import { LayoutComponent } from './components/layout/layout.component';

export const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    canActivate: [AuthGuard],
    children: [
      { path: '', component: HomePageComponent },
      { path: 'admin/users', loadChildren: () => import('./admin/users/users.routes').then(m => m.USERS_ROUTES) },
      { path: 'admin/organizations', loadChildren: () => import('./admin/organizations/organizations.routes').then(m => m.ORGS_ROUTES) }
    ]
  },
  { path: 'login', component: LoginPageComponent }
];
