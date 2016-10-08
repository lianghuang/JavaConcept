package com.test.java.clone;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.test.java.utils.JsonUtils;

/**
 * @author Huang, Liangliang
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DeepCopyTest {

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
    public void changeSoundWhenDeepClone() throws Exception{
        cat.setSound("wuwu");
        Cat cloneCat=JsonUtils.readValue(JsonUtils.toString(cat), Cat.class);
        Assert.assertEquals("wuwu", cloneCat.getSound());
    }
    @Test
    public void changeBabyWhenDeepClone() throws Exception{
        Cat baby=cat.getBabyCat();
        Cat cloneCat=JsonUtils.readValue(JsonUtils.toString(cat), Cat.class);
        Assert.assertNotSame(baby, cloneCat.getBabyCat());
        baby.setFeet(4);
        Assert.assertEquals(new Integer(0), cloneCat.getBabyCat().getFeet());
    }
}
