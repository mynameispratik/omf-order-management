package com.tastyfood.omf.ordermanagement.statemachine;

import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import com.tastyfood.omf.ordermanagement.entity.OrderEvent;
import com.tastyfood.omf.ordermanagement.entity.OrderState;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableStateMachineFactory
@Configuration
public class FoodOrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderState, OrderEvent> {
	
	
	@Override
	public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states) throws Exception {
		states.withStates().initial(OrderState.NEW).states(EnumSet.allOf(OrderState.class)).end(OrderState.CANCELLED);

	}

	@Override
	public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> transitions) throws Exception{
	}

}
