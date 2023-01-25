import { IUser } from '@/shared/model/user.model';

export interface IBadge {
  id?: string;
  badge?: string | null;
  count?: number | null;
  user?: IUser | null;
}

export class Badge implements IBadge {
  constructor(public id?: string, public badge?: string | null, public count?: number | null, public user?: IUser | null) {}
}
