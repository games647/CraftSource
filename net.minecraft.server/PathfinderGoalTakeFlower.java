package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

public class PathfinderGoalTakeFlower extends PathfinderGoal {

    private EntityVillager a;
    private EntityIronGolem b;
    private int c;
    private boolean d = false;

    public PathfinderGoalTakeFlower(EntityVillager entityvillager) {
        this.a = entityvillager;
        this.a(3);
    }

    public boolean a() {
        if (this.a.getAge() >= 0) {
            return false;
        } else if (!this.a.world.u()) {
            return false;
        } else {
            List list = this.a.world.a(EntityIronGolem.class, this.a.boundingBox.grow(6.0D, 2.0D, 6.0D));

            if (list.isEmpty()) {
                return false;
            } else {
                Iterator iterator = list.iterator();

                while (iterator.hasNext()) {
                    EntityIronGolem entityirongolem = (EntityIronGolem) iterator.next();

                    if (entityirongolem.o() > 0) {
                        this.b = entityirongolem;
                        break;
                    }
                }

                return this.b != null;
            }
        }
    }

    public boolean b() {
        return this.b.o() > 0;
    }

    public void c() {
        this.c = this.a.aB().nextInt(320);
        this.d = false;
        this.b.getNavigation().g();
    }

    public void d() {
        this.b = null;
        this.a.getNavigation().g();
    }

    public void e() {
        this.a.getControllerLook().a(this.b, 30.0F, 30.0F);
        if (this.b.o() == this.c) {
            this.a.getNavigation().a((EntityLiving) this.b, 0.15F);
            this.d = true;
        }

        if (this.d && this.a.e(this.b) < 4.0D) {
            this.b.f(false);
            this.a.getNavigation().g();
        }
    }
}
