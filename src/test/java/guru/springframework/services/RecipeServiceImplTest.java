package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    RecipeServiceImpl recipeServiceImpl;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        recipeServiceImpl = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(new Recipe());

        Mockito.when(recipeRepository.findAll()).thenReturn(recipesData);
        assertEquals(1, recipeServiceImpl.getRecipes().size());
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}