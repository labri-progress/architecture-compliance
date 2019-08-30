package fr.ubordeaux.ddd.examples.application;

import fr.ubordeaux.ddd.annotations.classes.Service;
import fr.ubordeaux.ddd.examples.domain.AggregateEntityA;
import fr.ubordeaux.ddd.examples.domain.FactoryA;
import fr.ubordeaux.ddd.examples.domain.RepositoryInterface;

@Service
public class ServiceImplementationApplicationLayer implements ServiceInterfaceApplicationLayer {
    private final RepositoryInterface repository;
    private final FactoryA factory;

    public ServiceImplementationApplicationLayer(RepositoryInterface repository, FactoryA factory) {
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public void addAggregate(String one) {
        this.repository.store(factory.newAggregateA(one));
    }

    @Override
    public void addAggregate(String one, AggregateEntityA prototype) {
        this.repository.store(factory.newAggregateA(one, prototype));
    }

    @Override
    public void addAggregate(AggregateEntityA aggregate) {
        this.repository.store(aggregate);
    }
}
