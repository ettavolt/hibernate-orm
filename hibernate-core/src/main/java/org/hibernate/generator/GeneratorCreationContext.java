/*
 * SPDX-License-Identifier: LGPL-2.1-or-later
 * Copyright Red Hat Inc. and Hibernate Authors
 */
package org.hibernate.generator;

import java.util.Properties;

import org.hibernate.Incubating;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.RootClass;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

/**
 * Access to information useful during {@linkplain Generator} creation and initialization.
 *
 * @see AnnotationBasedGenerator
 * @see org.hibernate.id.Configurable#configure(GeneratorCreationContext, Properties)
 *
 * @since 6.2
 */
@Incubating
public interface GeneratorCreationContext {
	/**
	 * View of the relational database objects (tables, sequences, ...) and namespaces (catalogs and schemas).
	 */
	Database getDatabase();

	/**
	 * Access to available services.
	 */
	ServiceRegistry getServiceRegistry();

	/**
	 * The default catalog name, if one.
	 */
	String getDefaultCatalog();

	/**
	 * The default schema name, if one.
	 */
	String getDefaultSchema();

	/**
	 * Mapping details for the entity.
	 */
	PersistentClass getPersistentClass();

	/**
	 * Mapping details for the root of the {@linkplain #getPersistentClass() entity} hierarchy.
	 */
	RootClass getRootClass();

	/**
	 * The entity identifier or id-bag property details.
	 */
	Property getProperty();

	/**
	 * Mapping details for the identifier type.
	 */
	default Type getType() {
		return getProperty().getType();
	}
}
