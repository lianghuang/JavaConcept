package com.test.java.clone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**Shallow clone is a copying the reference pointer to the object, 
 * which mean the new object is pointing to the same memory reference of the old object. 
 * The memory usage is lower.
 * @author Huang, Liangliang
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ShallowCopyTest {

    private Cat cat;
    
    @Before
    public void setup(){
        cat=new Cat();
        cat.setFeet(4);
        cat.setTail(1);
        cat.setSound("miao~");
        Cat babyCat=new Cat();
        babyCat.setFeet(0);
        cat.setBabyCat(babyCat);
    }
    
    @Test
    public void changeSoundWhenClone(){
        cat.setSound("wuwu");
        Cat cloneCat=(Cat) cat.clone();
        Assert.assertEquals("wuwu", cloneCat.getSound());
    }
    @Test
    public void notChangeBabyWhenClone(){
        Cat baby=cat.getBabyCat();
        Cat cloneCat=(Cat) cat.clone();
        Assert.assertSame(baby, cloneCat.getBabyCat());
    }
}
